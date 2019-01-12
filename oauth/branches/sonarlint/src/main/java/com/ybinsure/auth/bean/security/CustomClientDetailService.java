package com.ybinsure.auth.bean.security;

import com.ybinsure.auth.model.data.ClientDO;
import com.ybinsure.auth.service.data.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomClientDetailService implements ClientDetailsService {

    private final ClientService clientService;

    @Autowired
    public CustomClientDetailService(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public ClientDetails loadClientByClientId(String client) throws ClientRegistrationException {
        Optional<ClientDO> optionalClientLinkGrantTypes = clientService.queryFullLinkedInfo(client);
        return optionalClientLinkGrantTypes.map(ClientDO::getClientDetails).orElse(null);
    }

}
