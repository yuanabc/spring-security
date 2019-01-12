package com.ybinsure.auth.serviceImpl.data;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ybinsure.auth.constant.CacheKey;
import com.ybinsure.auth.constant.StatusCode;
import com.ybinsure.auth.mapper.data.ChannelDOMapper;
import com.ybinsure.auth.mapper.extend.ExtendChannelMapper;
import com.ybinsure.auth.model.data.ChannelDO;
import com.ybinsure.auth.model.data.ChannelDOExample;
import com.ybinsure.auth.model.transfer.page.PageParam;
import com.ybinsure.auth.model.transfer.page.PageResult;
import com.ybinsure.auth.service.data.ChannelService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultChannelService implements ChannelService {

    private static final Integer defaultOrderCode = 100;
    private final ChannelDOMapper channelDOMapper;
    private final ExtendChannelMapper extendChannelMapper;

    @Override
    public Optional<ChannelDO> query(String id) {
        if (StringUtils.isBlank(id)) {
            return Optional.empty();
        }
        return Optional.ofNullable(channelDOMapper.selectByPrimaryKey(id));
    }

    @Override
    @Cacheable(value = CacheKey.channelQueryAll)
    public Optional<List<ChannelDO>> queryAll() {
        List<ChannelDO> result = extendChannelMapper.queryAll(StatusCode.ENABLE, StatusCode.DISABLE);
        return Optional.of(result);
    }

    @Override
    public Optional<List<ChannelDO>> querySalesChannel(String channelCode) {
        if (StringUtils.isBlank(channelCode)) {
            return Optional.empty();
        }
        ChannelDOExample example = new ChannelDOExample();
        example.or()
                .andProxyChannelCodeEqualTo(channelCode)
                .andDeletedEqualTo(StatusCode.DISABLE)
                .andStatusEqualTo(StatusCode.ENABLE);
        List<ChannelDO> result = channelDOMapper.selectByExample(example);
        result.forEach(ChannelDO::clear);
        return Optional.of(result);
    }

    @Override
    public Optional<ChannelDO> queryByChannelCode(String channelCode) {
        if (StringUtils.isBlank(channelCode)) {
            return Optional.empty();
        }
        ChannelDOExample example = new ChannelDOExample();
        example.or().andCodeEqualTo(channelCode)
                .andDeletedEqualTo(StatusCode.DISABLE);
        List<ChannelDO> result = channelDOMapper.selectByExample(example);
        if (result.isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(result.get(0));
    }

    @Override
    public Optional<List<ChannelDO>> queryShouldExpireChannels() {
        ChannelDOExample example = new ChannelDOExample();
        example.or().andStatusEqualTo(StatusCode.ENABLE).andExpireTimeLessThanOrEqualTo(System.currentTimeMillis());
        example.or().andStatusEqualTo(StatusCode.ENABLE).andStartTimeGreaterThanOrEqualTo(System.currentTimeMillis());
        example.or().andStatusEqualTo(StatusCode.ENABLE).andExpireTimeIsNull();
        example.or().andStatusEqualTo(StatusCode.ENABLE).andStartTimeIsNull();
        List<ChannelDO> channelDOS = channelDOMapper.selectByExample(example);
        if (channelDOS == null) {
            return Optional.empty();
        }
        return Optional.of(channelDOS);
    }

    @Override
    public Optional<String> queryInnerCode(String everyCode) {
        if (StringUtils.isBlank(everyCode)) {
            return Optional.empty();
        }
        ChannelDOExample example = new ChannelDOExample();
        example.or().andOutCodeEqualTo(everyCode)
                .andDeletedEqualTo(StatusCode.DISABLE);
        example.or().andCodeEqualTo(everyCode)
                .andDeletedEqualTo(StatusCode.DISABLE);
        List<ChannelDO> res = channelDOMapper.selectByExample(example);
        if (res == null || res.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(res.get(0).getCode());
    }

    @Override
    public Optional<PageResult<List<ChannelDO>>> queryWithPage(PageParam<ChannelDO> pageParam) {
        if (pageParam.blank() || pageParam.getModel() == null) {
            return Optional.empty();
        }
        ChannelDO model = pageParam.getModel();
        ChannelDOExample example = new ChannelDOExample();
        example.setOrderByClause("sort desc");
        ChannelDOExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(StatusCode.DISABLE);
        if (model.getStatus() != null) {
            criteria.andStatusEqualTo(model.getStatus());
        }
        if (StringUtils.isNotBlank(model.getShortName())) {
            criteria.andShortNameLike("%" + model.getShortName().trim() + "%");
        }
        if (StringUtils.isNotBlank(model.getOutCode())) {
            criteria.andOutCodeLike("%" + model.getOutCode().trim() + "%");
        }
        if (StringUtils.isNotBlank(model.getType())) {
            criteria.andTypeEqualTo(model.getType());
        }
        PageHelper.startPage(pageParam.getPage(), pageParam.getSize());
        List<ChannelDO> result = channelDOMapper.selectByExample(example);
        long count = ((Page)result).getTotal();
        return Optional.of(PageResult.instance(count, result));
    }

    @Override
    public Integer maxOrderCode() {
        Integer maxOrderCode = extendChannelMapper.queryMaxOrderCode();
        if (maxOrderCode == null) {
            return defaultOrderCode;
        }
        return maxOrderCode;
    }

    @Override
    @CacheEvict(value = CacheKey.channelQueryAll, allEntries = true)
    public Optional<String> insert(ChannelDO channelDO) {
        if (channelDO == null) {
            return Optional.empty();
        }
        if (StringUtils.isBlank(channelDO.getOutCode())) {
            channelDO.setOutCode(channelDO.getCode());
        }
        channelDO.setOrderCode((short) (maxOrderCode() + 1));
        channelDO.setCreateTime(System.currentTimeMillis());
        channelDO.setUpdateTime(System.currentTimeMillis());
        if (channelDOMapper.insertSelective(channelDO) > 0) {
            return Optional.of(channelDO.getId());
        }
        return Optional.empty();
    }

    @Override
    @CacheEvict(value = CacheKey.channelQueryAll, allEntries = true)
    public boolean update(ChannelDO param) {
        if (StringUtils.isBlank(param.getId())) {
            return false;
        }
        param.setCode(null);
        param.setDeleted(null);
        param.setUpdateTime(System.currentTimeMillis());
        return channelDOMapper.updateByPrimaryKeySelective(param) > 0;
    }

    @Override
    @CacheEvict(value = CacheKey.channelQueryAll, allEntries = true)
    public boolean delete(String id) {
        if (StringUtils.isBlank(id)) {
            return false;
        }
        ChannelDO param = new ChannelDO();
        param.setId(id);
        param.setDeleted(StatusCode.ENABLE);
        return channelDOMapper.updateByPrimaryKeySelective(param) > 0;
    }

    @Override
    @CacheEvict(value = {CacheKey.channelQueryAll, CacheKey.companyQueryAllWithTree, CacheKey.companyQueryCompanyTree}, allEntries = true, condition = "#result")
    public boolean disable(String id) {
        if (StringUtils.isBlank(id)) {
            return false;
        }
        ChannelDO param = new ChannelDO();
        param.setId(id);
        param.setStatus(StatusCode.DISABLE);
        return channelDOMapper.updateByPrimaryKeySelective(param) > 0;
    }

    @Override
    @CacheEvict(value = {CacheKey.channelQueryAll, CacheKey.companyQueryAllWithTree, CacheKey.companyQueryCompanyTree}, allEntries = true)
    public boolean recovery(String id) {
        if (StringUtils.isBlank(id)) {
            return false;
        }
        ChannelDO param = new ChannelDO();
        param.setId(id);
        param.setStatus(StatusCode.ENABLE);
        boolean res = channelDOMapper.updateByPrimaryKeySelective(param) > 0;
        return res;
    }

    @Override
    public boolean isExist(ChannelDO param) {
        if (StringUtils.isBlank(param.getCode()) && StringUtils.isBlank(param.getId())) {
            return false;
        }
        ChannelDOExample example = new ChannelDOExample();
        ChannelDOExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(param.getCode())) {
            criteria.andCodeEqualTo(param.getCode());
        }
        if (StringUtils.isNotBlank(param.getId())) {
            criteria.andIdEqualTo(param.getId());
        }
        return channelDOMapper.countByExample(example) > 0;
    }
}
