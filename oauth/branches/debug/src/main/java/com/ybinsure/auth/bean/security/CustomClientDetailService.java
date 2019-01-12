package com.ybinsure.auth.bean.security;

import com.ybinsure.auth.model.link.ClientExtend;
import com.ybinsure.auth.service.link.ClientExtendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Optional;

@Component
public class CustomClientDetailService implements ClientDetailsService {

    private final ClientExtendService clientExtendService;

    @Autowired
    public CustomClientDetailService(ClientExtendService clientExtendService) {
        Assert.notNull(clientExtendService, "ClientLinkGrantTypesService不能为空");
        this.clientExtendService = clientExtendService;
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        Optional<ClientExtend> optionalClientLinkGrantTypes = clientExtendService.query(clientId);
        return optionalClientLinkGrantTypes.map(ClientExtend::getClientDetails).orElse(null);
    }

}
