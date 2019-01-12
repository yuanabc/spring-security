package com.ybinsure.auth.endpoint.data;

import com.ybinsure.auth.constant.ApiPath;
import com.ybinsure.auth.model.transfer.Result;
import com.ybinsure.auth.service.link.UserLinkUserRelateCompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserLinkUserRelateCompanyEndpoint {

    private final UserLinkUserRelateCompanyService userLinkUserRelateCompanyService;

    @GetMapping(ApiPath.USER_LINK_USER_RELATE_COMPANY_EXIST_USER)
    public Result<Boolean> existUser(@PathVariable("companyId") String companyId) {
        if (userLinkUserRelateCompanyService.isExistUser(companyId)) {
            return Result.success(true);
        }
        return Result.success(false);
    }

}
