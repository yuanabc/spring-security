package com.ybinsure.auth.service.wrap;

public interface ChannelWrapService {

    boolean delete(String id);

    boolean disable(String id, boolean isClearToken);
}
