package com.ybinsure.auth.serviceImpl.data;

import com.ybinsure.auth.exception.FailResultException;
import com.ybinsure.auth.mapper.data.WebConfigDoMapper;
import com.ybinsure.auth.mapper.extend.ExtendWebConfigMapper;
import com.ybinsure.auth.model.data.WebConfigDO;
import com.ybinsure.auth.model.data.WebConfigDoExample;
import com.ybinsure.auth.service.data.WebConfigService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DefaultWebConfigService implements WebConfigService {

    private final WebConfigDoMapper webConfigDoMapper;
    private final ExtendWebConfigMapper extendWebConfigMapper;

    @Override
    @Transactional
    public boolean insertList(List<WebConfigDO> param) {
        if (param == null || param.isEmpty()) {
            return true;
        }
        param.forEach(webConfigDo -> {
            webConfigDo.setCreateTime(System.currentTimeMillis());
            webConfigDo.setUpdateTime(System.currentTimeMillis());
        });
        return extendWebConfigMapper.insertList(param) == param.size();
    }

    @Override
    @Transactional
    public boolean delete(List<String> values) {
        if (values == null || values.isEmpty()) {
            return true;
        }
        WebConfigDoExample example = new WebConfigDoExample();
        example.or().andValueIn(values);
        webConfigDoMapper.deleteByExample(example);
        return webConfigDoMapper.selectByExample(example).size() == 0;
    }

    @Override
    @Transactional
    public boolean deleteAndInsertList(List<WebConfigDO> param) {
        if (param == null || param.isEmpty()) {
            return true;
        }
        List<String> values = Optional.ofNullable(param).orElseGet(ArrayList::new)
                .stream().map(WebConfigDO::getValue).collect(Collectors.toList());
        if (!delete(values)) {
            throw FailResultException.nonError();
        }
        if (!insertList(param)) {
            throw FailResultException.nonError();
        }
        return true;
    }


    @Override
    public Optional<List<WebConfigDO>> query(String channelCode) {
        if (StringUtils.isBlank(channelCode)) {
            return Optional.empty();
        }
        WebConfigDoExample example = new WebConfigDoExample();
        example.or().andValueEqualTo(channelCode);
        return Optional.ofNullable(webConfigDoMapper.selectByExample(example));
    }

    @Override
    public Optional<WebConfigDO> queryByCode(WebConfigDO param) {
        if (StringUtils.isBlank(param.getCode()) || StringUtils.isBlank(param.getValue())) {
            return Optional.empty();
        }
        WebConfigDoExample example = new WebConfigDoExample();
        example.or().andCodeEqualTo(param.getCode())
                .andValueEqualTo(param.getValue());
        List<WebConfigDO> webConfigDOS = webConfigDoMapper.selectByExample(example);
        if (webConfigDOS == null || webConfigDOS.isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(webConfigDOS.get(0));
    }

}
