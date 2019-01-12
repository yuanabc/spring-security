package com.ybinsure.auth.serviceImpl.wrap;

import com.ybinsure.auth.model.data.UserDO;
import com.ybinsure.auth.service.data.UserService;
import com.ybinsure.auth.service.tool.EmptyPasswordService;
import com.ybinsure.auth.service.tool.RestTemplateRequestService;
import com.ybinsure.auth.service.tool.TokenClearService;
import com.ybinsure.auth.service.wrap.UserWrapService;
import com.ybinsure.auth.util.SplitUserNameUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class DefaultUserWrapService implements UserWrapService {

    private final UserService userService;
    private final TokenClearService tokenClearService;
    private final EmptyPasswordService emptyPasswordService;
    private final RestTemplateRequestService restTemplateRequestService;

    @Override
    public boolean delete(String id) {
        // token缓存机制变更，过度操作
        loginOperate(id);
        boolean res = userService.delete(id);
        if (res) {
            tokenClearService.clearByUserIds(Collections.singletonList(id));
        }
        return res;
    }

    @Override
    public boolean disable(String id) {
        // token缓存机制变更，过度操作
        loginOperate(id);
        boolean res = userService.disable(id);
        if (res) {
            tokenClearService.clearByUserIds(Collections.singletonList(id));
        }
        return res;
    }

    private void loginOperate(String id) {
        UserDO param = userService.query(id).orElseGet(UserDO::new);
        emptyPasswordService.setDefaultPassword(param);
        String joinUserName = SplitUserNameUtils.join(param.getUserName(), param.getChannelCode());
        restTemplateRequestService.tokenWithFrontClient(joinUserName, param.getPassword());
    }
}
