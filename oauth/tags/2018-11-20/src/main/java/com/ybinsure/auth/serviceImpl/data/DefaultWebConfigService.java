package com.ybinsure.auth.serviceImpl.data;

import com.ybinsure.auth.exception.FailResultException;
import com.ybinsure.auth.mapper.auto.WebConfigDoMapper;
import com.ybinsure.auth.mapper.custom.CustomWebConfigMapper;
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
    private final CustomWebConfigMapper customWebConfigMapper;

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
        return customWebConfigMapper.insertList(param) == param.size();
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
    public Optional<List<WebConfigDO>> queryByValue(String channelCode) {
        if (StringUtils.isBlank(channelCode)) {
            return Optional.empty();
        }
        WebConfigDoExample example = new WebConfigDoExample();
        example.or().andValueEqualTo(channelCode);
        return Optional.ofNullable(webConfigDoMapper.selectByExample(example));
    }

    @Override
    public Optional<WebConfigDO> queryByCode(String code, String value) {
        if (StringUtils.isAnyBlank(code, value)) {
            return Optional.empty();
        }
        WebConfigDoExample example = new WebConfigDoExample();
        example.or().andCodeEqualTo(code)
                .andValueEqualTo(value);
        List<WebConfigDO> webConfigDOS = webConfigDoMapper.selectByExample(example);
        if (webConfigDOS == null || webConfigDOS.isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(webConfigDOS.get(0));
    }

}
