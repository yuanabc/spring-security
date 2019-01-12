package com.ybinsure.auth.serviceImpl.data;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ybinsure.auth.constant.*;
import com.ybinsure.auth.enums.CodeTypeEnum;
import com.ybinsure.auth.mapper.data.CompanyDOMapper;
import com.ybinsure.auth.mapper.extend.ExtendCompanyDOMapper;
import com.ybinsure.auth.model.data.ChannelDO;
import com.ybinsure.auth.model.data.CompanyDO;
import com.ybinsure.auth.model.data.CompanyDOExample;
import com.ybinsure.auth.model.data.DistrictDO;
import com.ybinsure.auth.model.transfer.page.PageParam;
import com.ybinsure.auth.model.transfer.page.PageResult;
import com.ybinsure.auth.model.transfer.tree.CompanyTreeNode;
import com.ybinsure.auth.model.transfer.tree.TreeNode;
import com.ybinsure.auth.service.adapter.DistrictAdapterService;
import com.ybinsure.auth.service.data.ChannelService;
import com.ybinsure.auth.service.data.CompanyService;
import com.ybinsure.auth.service.tool.CompanyTreeService;
import com.ybinsure.auth.service.tool.OrderCodeService;
import com.ybinsure.auth.service.tool.TreeNodeService;
import com.ybinsure.auth.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DefaultCompanyService implements CompanyService {

    private final static Logger logger = LoggerFactory.getLogger(DefaultCompanyService.class);
    private final static Integer filterPolicyArea = 1;
    private final static Integer filterRoot = 2;

    private final CompanyDOMapper companyDOMapper;
    private final ExtendCompanyDOMapper extendCompanyDOMapper;
    private final TreeNodeService treeNodeService;
    private final CompanyTreeService companyTreeService;
    private final ChannelService channelService;
    private final OrderCodeService orderCodeService;
    private final DistrictAdapterService districtAdapterService;

    @Override
    @CacheEvict(value = {CacheKey.companyQueryAllWithTree, CacheKey.companyQueryCompanyTree}, allEntries = true)
    public boolean delete(String id) {
        if (StringUtils.isBlank(id)) {
            return false;
        }
        CompanyDO clone = new CompanyDO();
        clone.setId(id);
        clone.setDeleted(StatusCode.ENABLE);
        return companyDOMapper.updateByPrimaryKeySelective(clone) > 0;
    }

    @Override
    public boolean disable(String id) {
        if (StringUtils.isBlank(id)) {
            return false;
        }
        CompanyDO clone = new CompanyDO();
        clone.setId(id);
        clone.setStatus(StatusCode.DISABLE);
        return companyDOMapper.updateByPrimaryKeySelective(clone) > 0;
    }

    @Override
    public boolean recovery(String id) {
        if (StringUtils.isBlank(id)) {
            return false;
        }
        CompanyDO clone = new CompanyDO();
        clone.setId(id);
        clone.setStatus(StatusCode.ENABLE);
        return update(clone);
    }

    @Override
    @CacheEvict(value = {CacheKey.companyQueryAllWithTree, CacheKey.companyQueryCompanyTree}, allEntries = true)
    public boolean update(CompanyDO param) {
        if (StringUtils.isBlank(param.getId())) {
            return false;
        }
        param.setUpdateTime(System.currentTimeMillis());
        boolean updateRes = companyDOMapper.updateByPrimaryKeySelective(param) > 0;
        if (updateRes) {
            Optional<CompanyDO> companyDO = query(param.getId());
        }
        return updateRes;
    }


    @Override
    @CacheEvict(value = {CacheKey.companyQueryAllWithTree, CacheKey.companyQueryCompanyTree}, allEntries = true)
    public Optional<String> insert(CompanyDO param) {
        if (param == null ||
                !channelService.isExist(ChannelDO.createInstanceWithCode(param.getChannelCode()))) {
            return Optional.empty();
        }
        CompanyDO company = new CompanyDO();
        company.setId(param.getParentId());
        if (!isExist(company)) {
            return Optional.empty();
        }
        Optional<Long> maxCodeOptional = orderCodeService.maxCode(param.getChannelCode(), CodeTypeEnum.COMPANY, this);
        if (!maxCodeOptional.isPresent()) {
            return Optional.empty();
        }
        param.setCode(maxCodeOptional.get());
        param.setCreateTime(System.currentTimeMillis());
        param.setUpdateTime(System.currentTimeMillis());
        if (companyDOMapper.insertSelective(param) > 0) {
            return Optional.of(param.getId());
        }
        return Optional.empty();
    }

    @Override
    @CacheEvict(value = {CacheKey.companyQueryAllWithTree, CacheKey.companyQueryCompanyTree}, allEntries = true)
    public Optional<String> insertHead(CompanyDO param) {
        Optional<CompanyDO> root = queryRoot();
        if (!root.isPresent()) {
            return Optional.empty();
        }
        param.setParentId(root.get().getId());
        Optional<Long> maxCodeOptional = orderCodeService.maxCode(param.getChannelCode(), CodeTypeEnum.COMPANY, this);
        if (!maxCodeOptional.isPresent()) {
            return Optional.empty();
        }
        param.setCode(maxCodeOptional.get());
        if (companyDOMapper.insertSelective(param) > 0) {
            return Optional.of(param.getId());
        }
        return Optional.empty();
    }

    @Override
    public boolean isExist(CompanyDO param) {
        boolean isId = StringUtils.isNotBlank(param.getId());
        boolean isSourceCode = StringUtils.isNotBlank(param.getOldCode()) && StringUtils.isNotBlank(param.getChannelCode());
        if (isId || isSourceCode) {
            CompanyDOExample example = new CompanyDOExample();
            CompanyDOExample.Criteria criteria = example.createCriteria();
            if (StringUtils.isNotBlank(param.getId())) {
                criteria.andIdEqualTo(param.getId());
            }
            if (StringUtils.isNotBlank(param.getOldCode())) {
                criteria.andOldCodeEqualTo(param.getOldCode());
            }
            if (StringUtils.isNotBlank(param.getChannelCode())) {
                criteria.andChannelCodeEqualTo(param.getChannelCode());
            }
            return companyDOMapper.countByExample(example) > 0;
        }
        return false;
    }

    public Optional<List<CompanyDO>> queryAll() {
        return Optional.ofNullable(extendCompanyDOMapper.queryAll(StatusCode.ENABLE, StatusCode.DISABLE));
    }

    @Override
    @Cacheable(value = CacheKey.companyQueryAllWithTree)
    public Optional<List<TreeNode>> queryTree() {
        return queryAll().map(treeNodeService::convert);
    }

    @Override
    @Cacheable(value = CacheKey.companyQueryCompanyTree)
    public Optional<List<CompanyTreeNode>> queryCompanyTree() {
        List<CompanyDO> allCompanies = queryAll().orElseGet(ArrayList::new);
        setDistrict(allCompanies);
        List<CompanyTreeNode> companyTreeNodes = allCompanies.stream()
                .map(CompanyDO::convertCompanyTreeNode)
                .collect(Collectors.toList());
        return Optional.of(companyTreeService.convert(companyTreeNodes));
    }

    @Override
    public Optional<List<CompanyDO>> queryByUserName(String userName, String channelCode, String linkType) {
        if (StringUtils.isBlank(userName) ||
                StringUtils.isBlank(channelCode) ||
                StringUtils.isBlank(linkType)) {
            return Optional.empty();
        }
        return Optional.ofNullable(extendCompanyDOMapper.queryByUserName(userName, channelCode, linkType));
    }

    @Override
    public Optional<CompanyDO> query(String id) {
        if (StringUtils.isBlank(id)) {
            return Optional.empty();
        }
        CompanyDOExample example = new CompanyDOExample();
        example.or().andIdEqualTo(id)
                .andDeletedEqualTo(StatusCode.DISABLE);
        List<CompanyDO> companyDOS = companyDOMapper.selectByExample(example);
        if (companyDOS.isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(companyDOS.get(0));
    }

    @Override
    public Optional<CompanyDO> query(String oldCode, String channelCode) {
        if (StringUtils.isBlank(oldCode) || StringUtils.isBlank(channelCode)) {
            return Optional.empty();
        }
        CompanyDOExample example = new CompanyDOExample();
        example.or().andOldCodeEqualTo(oldCode)
                .andChannelCodeEqualTo(channelCode)
                .andDeletedEqualTo(StatusCode.DISABLE);
        List<CompanyDO> res = companyDOMapper.selectByExample(example);
        if (res == null || res.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(res.get(0));
    }

    @Override
    public Optional<List<CompanyDO>> queryByCodes(List<Long> codes) {
        if (codes == null || codes.isEmpty()) {
            return Optional.empty();
        }
        CompanyDOExample example = new CompanyDOExample();
        example.or().andCodeIn(codes).andDeletedEqualTo(StatusCode.DISABLE);
        List<CompanyDO> result = companyDOMapper.selectByExample(example);
        if (result == null || result.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(result);
    }

    @Override
    public Optional<List<CompanyDO>> querys(List<String> param) {
        if (param == null || param.isEmpty()) {
            return Optional.empty();
        }
        CompanyDOExample example = new CompanyDOExample();
        example.or().andIdIn(param)
                .andDeletedEqualTo(StatusCode.DISABLE);
        return Optional.of(companyDOMapper.selectByExample(example));
    }

    @Override
    public Optional<List<CompanyDO>> queryByChannelCode(String channelCode) {
        if (StringUtils.isBlank(channelCode)) {
            return Optional.empty();
        }
        CompanyDOExample example = new CompanyDOExample();
        example.or().andChannelCodeEqualTo(channelCode)
                .andDeletedEqualTo(StatusCode.DISABLE);
        return Optional.ofNullable(companyDOMapper.selectByExample(example));
    }

    @Override
    public Optional<CompanyDO> queryRoot() {
        CompanyDOExample example = new CompanyDOExample();
        example.or()
                .andChannelCodeEqualTo(ChannelCode.YUEBAO)
                .andLevelEqualTo(CompanyLevelCode.ROOT)
                .andStatusEqualTo(StatusCode.ENABLE);
        List<CompanyDO> queryResult = companyDOMapper.selectByExample(example);
        if (queryResult.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(queryResult.get(0));
    }

    @Override
    public Optional<List<CompanyDO>> queryChild(String id) {
        if (StringUtils.isBlank(id)) {
            return Optional.empty();
        }
        CompanyDOExample example = new CompanyDOExample();
        example.or().andParentIdEqualTo(id)
                .andDeletedEqualTo(StatusCode.DISABLE);
        return Optional.ofNullable(companyDOMapper.selectByExample(example));
    }

    @Override
    public Optional<List<CompanyDO>> queryAllParents(String id) {
        return queryAllParentsWithSelf(id)
                .map(companyDOS ->
                        companyDOS.stream().filter(companyDO -> !StringUtils.equals(companyDO.getId(), id))
                                .collect(Collectors.toList()));
    }

    @Override
    public Optional<List<CompanyDO>> queryAllParentsWithSelf(String id) {
        if (StringUtils.isBlank(id)) {
            return Optional.empty();
        }
        List<CompanyDO> result = new ArrayList<>();
        int count = 10; // 防止极端情况死循环
        String currentId = id;
        Optional<CompanyDO> queryResult;
        do {
            count--;
            queryResult = query(currentId);
            if (queryResult.isPresent()) {
                currentId = queryResult.get().getParentId();
                result.add(queryResult.get());
            }
        } while (queryResult.isPresent() && count > 0);
        return Optional.of(result);
    }

    @Override
    public Optional<List<TreeNode>> queryAllParentsTree(String id, Integer filterType) {
        if (StringUtils.isBlank(id)) {
            return Optional.empty();
        }
        List<CompanyDO> companyDOS = queryAllParentsWithSelf(id).orElseGet(ArrayList::new);
        // 筛选相同投保地的机构
        if (filterType.equals(filterPolicyArea)) {
            Optional<String> policyAreaCode = companyDOS.stream().filter(companyDO -> StringUtils.isNotBlank(companyDO.getAreaCode()) && StringUtils.equals(companyDO.getId(), id)).findAny().map(CompanyDO::getAreaCode);
            if (!policyAreaCode.isPresent()) {
                return Optional.empty();
            }
            companyDOS = companyDOS.stream().filter(companyDO -> StringUtils.equals(companyDO.getAreaCode(), policyAreaCode.get())).collect(Collectors.toList());
        }
        if (filterType.equals(filterRoot)) {
            companyDOS = companyDOS.stream().filter(companyDO -> !CompanyLevelCode.ROOT.equals(companyDO.getLevel())).collect(Collectors.toList());
        }
        // 筛选本节点
        companyDOS = companyDOS.stream().filter(companyDO -> !StringUtils.equals(id, companyDO.getId())).collect(Collectors.toList());
        return Optional.of(treeNodeService.convertCompany(companyDOS));
    }

    @Override
    public Optional<PageResult<List<CompanyDO>>> queryWithPage(PageParam<CompanyDO> pageParam) {
        if (pageParam.blank() || StringUtils.isBlank(pageParam.getModel().getChannelCode())) {
            return Optional.empty();
        }
        CompanyDO model = pageParam.getModel();
        CompanyDOExample example = new CompanyDOExample();
        CompanyDOExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("sort desc, create_time desc");
        criteria.andChannelCodeEqualTo(model.getChannelCode())
                .andDeletedEqualTo(StatusCode.DISABLE);
        if (model.getStatus() != null) {
            criteria.andStatusEqualTo(model.getStatus());
        }
        if (StringUtils.isNotBlank(model.getCompanyType())) {
            criteria.andCompanyTypeEqualTo(model.getCompanyType().trim());
        }
        if (StringUtils.isNotBlank(model.getProvince())) {
            criteria.andProvinceEqualTo(model.getProvince().trim());
        }
        if (StringUtils.isNotBlank(model.getCity())) {
            criteria.andCityEqualTo(model.getCity().trim());
        }
        if (StringUtils.isNotBlank(model.getName())) {
            criteria.andNameLike("%" + model.getName().trim() + "%");
        }
        if (StringUtils.isNotBlank(model.getOldCode())) {
            criteria.andOldCodeLike("%" + model.getOldCode().trim() + "%");
        }
        if (model.getCode() != null) {
            criteria.andCodeEqualTo(model.getCode());
        }
        PageHelper.startPage(pageParam.getPage(), pageParam.getSize());
        List<CompanyDO> result = companyDOMapper.selectByExample(example);
        setDistrict(result);
        long count = ((Page)result).getTotal();
        return Optional.of(PageResult.instance(count, result));
    }

    private void setDistrict(List<CompanyDO> companyDOS) {
        List<String> codes = new ArrayList<>();
        companyDOS.forEach(companyDO -> {
            if (StringUtils.isNotBlank(companyDO.getProvince())) {
                codes.add(companyDO.getProvince());
            }
            if (StringUtils.isNotBlank(companyDO.getCity())) {
                codes.add(companyDO.getCity());
            }
        });
        Optional<List<DistrictDO>> optionalDistrictDOS = districtAdapterService.queryProvinceAndCityByCodes(codes);
        // 未查询到地区编码时，使用空值
        DistrictDO empty = new DistrictDO();
        optionalDistrictDOS.ifPresent(districtDOS -> companyDOS.forEach(companyDO -> {
            // 设置省份
            String provinceName = districtDOS.stream()
                    .filter(districtDO -> StringUtils.equals(districtDO.getCode(), companyDO.getProvince()))
                    .findAny().orElse(empty).getName();
            String cityName = districtDOS.stream()
                    .filter(districtDO -> StringUtils.equals(districtDO.getCode(), companyDO.getCity()))
                    .findAny().orElse(empty).getName();
            companyDO.setProvince(provinceName);
            companyDO.setCity(cityName);
        }));
    }

    //todo 使用redis哈希重构
    @Override
    public Optional<List<CompanyDO>> querySimpleInfo(List<String> ids) {
        if (ids == null || ids.isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(extendCompanyDOMapper.querySimpleInfo(ids));
    }

    @Override
    public Optional<List<CompanyDO>> queryByProvinceAndCity(CompanyDO param) {
        if (StringUtils.isBlank(param.getProvince()) || StringUtils.isBlank(param.getCity()) || StringUtils.isBlank(param.getChannelCode())) {
            return Optional.empty();
        }
        CompanyDOExample example = new CompanyDOExample();
        example.or()
                .andProvinceEqualTo(param.getProvince())
                .andCityEqualTo(param.getCity())
                .andChannelCodeEqualTo(param.getChannelCode())
                .andCompanyTypeEqualTo(CompanyTypeCode.TEAM)
                .andDeletedEqualTo(StatusCode.DISABLE);
        return Optional.ofNullable(companyDOMapper.selectByExample(example));
    }

    @Override
    public void updateCompanyCode() {
        CompanyDOExample example = new CompanyDOExample();
        example.or().andCodeIsNull();
        List<CompanyDO> companyDOS = companyDOMapper.selectByExample(example);
        companyDOS.forEach(companyDO -> {
            Optional<Long> maxCodeOptional = orderCodeService.maxCode(companyDO.getChannelCode(), CodeTypeEnum.COMPANY, this);
            maxCodeOptional.ifPresent(maxCode -> {
                CompanyDO clone = new CompanyDO();
                clone.setId(companyDO.getId());
                clone.setCode(maxCode);
                boolean result = update(clone);
                logger.info("update company - {}", JsonUtil.toJson(clone).orElse(""));
                logger.info("update company result - {}", result);
            });
        });
    }

    @Override
    public Optional<Long> queryMaxCode(String channelCode, CodeTypeEnum codeTypeEnum, long min) {
        if (StringUtils.isBlank(channelCode)) {
            return Optional.empty();
        }
        return Optional.ofNullable(extendCompanyDOMapper.queryMaxCode(channelCode, min));
    }
}
