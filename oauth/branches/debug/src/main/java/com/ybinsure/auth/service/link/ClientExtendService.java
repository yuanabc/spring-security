package com.ybinsure.auth.service.link;

import com.ybinsure.auth.model.link.ClientExtend;

import java.util.Optional;

public interface ClientExtendService {

    Optional<ClientExtend> query(String clientId);
}
