package com.ybinsure.auth.serviceImpl.data;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ybinsure.auth.constant.CacheKey;
import com.ybinsure.auth.constant.OrderCode;
import com.ybinsure.auth.constant.StatusCode;
import com.ybinsure.auth.mapper.auto.ChannelDOMapper;
import com.ybinsure.auth.mapper.custom.CustomChannelMapper;
import com.ybinsure.auth.model.data.ChannelDO;
import com.ybinsure.auth.model.data.ChannelDOExample;
import com.ybinsure.auth.model.transfer.page.PageParam;
import com.ybinsure.auth.model.transfer.page.PageResult;
import com.ybinsure.auth.model.transfer.param.ChannelQueryPageParamDTO;
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

    private final ChannelDOMapper channelDOMapper;
    private final CustomChannelMapper customChannelMapper;

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
        ChannelDOExample example = new ChannelDOExample();
        example.setOrderByClause("sort desc, create_time desc");
        example.or().andStatusEqualTo(StatusCode.ENABLE)
                .andDeletedEqualTo(StatusCode.DISABLE);
        List<ChannelDO> result = channelDOMapper.selectByExample(example);
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
        return Optional.ofNullable(channelDOMapper.selectByExample(example));
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
    public Optional<PageResult<List<ChannelDO>>> queryWithPage(PageParam<ChannelQueryPageParamDTO> pageParam) {
        if (pageParam.blank()) {
            return Optional.empty();
        }
        pageParam.setKeywordPattern();
        String orderCase;
        if (StringUtils.isBlank(pageParam.getModel().getTimeSort())) {
            orderCase = "c.sort desc, c.create_time desc";
        } else if (StringUtils.equals(String.valueOf(OrderCode.ASC), pageParam.getModel().getTimeSort())) {
            orderCase = "c.create_time asc";
        } else {
            orderCase = "c.create_time desc";
        }
        pageParam.getModel().setTimeSort(orderCase);
        PageHelper.startPage(pageParam.getPage(), pageParam.getSize());
        List<ChannelDO> result = customChannelMapper.queryPage(pageParam);
        long count = ((Page)result).getTotal();
        return Optional.of(PageResult.instance(count, result));
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
        return channelDOMapper.updateByPrimaryKeySelective(param) > 0;
    }

    @Override
    public boolean isExist(ChannelDO param) {
        if (StringUtils.isBlank(param.getCode()) && StringUtils.isBlank(param.getId())) {
            return false;
        }
        ChannelDOExample example = new ChannelDOExample();
        ChannelDOExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(StatusCode.DISABLE);
        if (StringUtils.isNotBlank(param.getCode())) {
            criteria.andCodeEqualTo(param.getCode());
        }
        if (StringUtils.isNotBlank(param.getId())) {
            criteria.andIdEqualTo(param.getId());
        }
        return channelDOMapper.countByExample(example) > 0;
    }

    @Override
    public boolean isDisable(String channelCode) {
        if (StringUtils.isBlank(channelCode)) {
            return true;
        }
        ChannelDOExample example = new ChannelDOExample();
        example.or().andCodeEqualTo(channelCode)
                .andStatusEqualTo(StatusCode.ENABLE)
                .andDeletedEqualTo(StatusCode.DISABLE);
        return channelDOMapper.countByExample(example) == 0;
    }
}
