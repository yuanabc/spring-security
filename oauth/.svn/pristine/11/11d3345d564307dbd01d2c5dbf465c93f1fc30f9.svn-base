package com.ybinsure.auth.endpoint.data;

import com.ybinsure.auth.constant.ApiPath;
import com.ybinsure.auth.model.data.UserRelateRoleDO;
import com.ybinsure.auth.model.transfer.Result;
import com.ybinsure.auth.service.data.UserRelateRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserRelateRoleEndpoint {

    private final UserRelateRoleService userRelateRoleService;

    @GetMapping(ApiPath.USER_RELATE_ROLE_QUERY_BY_USER_ID)
    public Result<List<UserRelateRoleDO>> queryByUserId(@PathVariable("id") String id) {
        return Result.success(this.userRelateRoleService.queryByUserId(id).orElseGet(ArrayList::new));
    }

}
