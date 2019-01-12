package com.ybinsure.auth.endpoint.data;

import com.ybinsure.auth.constant.ApiPath;
import com.ybinsure.auth.constant.UserTypeCode;
import com.ybinsure.auth.model.data.UserDO;
import com.ybinsure.auth.model.link.UserExtend;
import com.ybinsure.auth.model.transfer.Result;
import com.ybinsure.auth.service.link.UserLinkCompanyService;
import com.ybinsure.auth.util.AuthenticationHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserLinkCompanyEndpoint {

    private final UserLinkCompanyService userLinkCompanyService;

    @GetMapping(ApiPath.USER_LINK_COMPANY_QUERY_BY_TOKEN)
    public Result<UserExtend> queryByToken() {
        String id = AuthenticationHelper.localContextHolderParser().getId().orElse(null);
        return userLinkCompanyService.queryById(id).map(Result::success).orElseGet(Result::nonError);
    }

    @GetMapping(ApiPath.USER_LINK_COMPANY_QUERY)
    public Result<UserExtend> query(@PathVariable("id") String id) {
        return userLinkCompanyService.queryById(id).map(Result::success).orElseGet(Result::nonError);
    }

    @GetMapping(ApiPath.USER_LINK_COMPANY_QUERY_SALES_BY_COMPANY_ID)
    public Result<List<UserDO>> querySalesByCompanyId(@PathVariable("companyId") String companyId) {
        return Result.success(userLinkCompanyService.queryUserByCompanyIdAndUserType(companyId, Collections.singletonList(UserTypeCode.SALE)).orElseGet(ArrayList::new));
    }

    @PostMapping(ApiPath.USER_LINK_COMPANY_QUERY_BY_AGENT_CODE)
    public Result<UserExtend> queryByAgentCode(@RequestBody() UserDO userDO) {
        return userLinkCompanyService.queryByAgentCode(userDO.getAgentCode(), userDO.getChannelCode()).map(Result::success).orElseGet(Result::nonError);
    }

}
