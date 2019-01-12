package com.ybinsure.auth.service.data;

import com.ybinsure.auth.model.data.ClientDO;

import java.util.Optional;

public interface ClientService {

    Optional<ClientDO> query(String clientId);

}
