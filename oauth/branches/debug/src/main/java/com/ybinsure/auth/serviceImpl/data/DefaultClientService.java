package com.ybinsure.auth.serviceImpl.data;

import com.ybinsure.auth.constant.StatusCode;
import com.ybinsure.auth.mapper.data.ClientDOMapper;
import com.ybinsure.auth.model.data.ClientDO;
import com.ybinsure.auth.model.data.ClientDOExample;
import com.ybinsure.auth.service.data.ClientService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultClientService implements ClientService {

    private final ClientDOMapper clientDOMapper;

    @Override
    public Optional<ClientDO> query(String clientId) {
        if (StringUtils.isBlank(clientId)) {
            return Optional.empty();
        }
        ClientDOExample example = new ClientDOExample();
        example.or().andClientEqualTo(clientId).andStatusEqualTo(StatusCode.ENABLE);
        List<ClientDO> res = clientDOMapper.selectByExample(example);
        if (res == null || res.isEmpty()) {
            return Optional.empty();
        }
        return Optional.ofNullable(res.get(0));
    }
}
