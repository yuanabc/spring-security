package com.ybinsure.auth.endpoint.data;

import com.ybinsure.auth.annotation.InsertAction;
import com.ybinsure.auth.annotation.UpdateAction;
import com.ybinsure.auth.constant.ApiPath;
import com.ybinsure.auth.model.data.CompanyDO;
import com.ybinsure.auth.model.link.CompanyLinkWebConfig;
import com.ybinsure.auth.model.transfer.Result;
import com.ybinsure.auth.service.data.CompanyService;
import com.ybinsure.auth.service.link.CompanyLinkWebConfigService;
import com.ybinsure.auth.util.ValidatedResultUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CompanyLinkWebConfigEndpoint {

    private final CompanyService companyService;
    private final CompanyLinkWebConfigService companyLinkWebConfigService;

    @PostMapping(ApiPath.COMPANY_LINK_WEB_CONFIG_INSERT)
    public Result<String> insert(
            @Validated({InsertAction.class}) @RequestBody() CompanyLinkWebConfig param, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        CompanyDO company = new CompanyDO();
        company.setOldCode(param.getCompanyDO().getOldCode());
        company.setChannelCode(param.getCompanyDO().getChannelCode());
        if (companyService.isExist(company)) {
            return Result.nonError("该机构编码已经存在，");
        }
        return companyLinkWebConfigService.insert(param).map(Result::success).orElseGet(Result::nonError);
    }

    @PostMapping(ApiPath.COMPANY_LINK_WEB_CONFIG_UPDATE)
    public Result<Boolean> update(
            @Validated({UpdateAction.class}) @RequestBody() CompanyLinkWebConfig param, BindingResult bindingResult
    ) {
        ValidatedResultUtil.checkFieldThrow(bindingResult);
        if (!companyLinkWebConfigService.update(param)) {
            return Result.nonError();
        }
        return Result.success();
    }




}
