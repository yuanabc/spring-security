package com.ybinsure.auth.serviceImpl.link;

import com.ybinsure.auth.mapper.link.ClientLinkedMapper;
import com.ybinsure.auth.model.link.ClientExtend;
import com.ybinsure.auth.service.link.ClientExtendService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultClientExtendService implements ClientExtendService {

    private final ClientLinkedMapper clientLinkedMapper;

    @Override
    public Optional<ClientExtend> query(String clientId) {
        if (StringUtils.isBlank(clientId)) {
            return Optional.empty();
        }
        return Optional.ofNullable(clientLinkedMapper.query(clientId));
    }
}
