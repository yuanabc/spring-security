package com.ybinsure.auth.serviceImpl.wrap;

import com.ybinsure.auth.exception.FailResultException;
import com.ybinsure.auth.model.data.CompanyDO;
import com.ybinsure.auth.model.link.UserExtend;
import com.ybinsure.auth.service.data.CompanyService;
import com.ybinsure.auth.service.link.UserLinkCompanyService;
import com.ybinsure.auth.service.tool.TokenClearService;
import com.ybinsure.auth.service.wrap.CompanyWrapService;
import com.ybinsure.auth.util.AuthenticationHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultCompanyWrapService implements CompanyWrapService {

    private final UserLinkCompanyService userLinkCompanyService;
    private final TokenClearService tokenClearService;
    private final CompanyService companyService;

    @Override
    public boolean delete(String id) {
        boolean res = companyService.delete(id);
        if (res) {
            tokenClearService.clearByCompanyId(id);
        }
        return res;
    }

    @Override
    public boolean disable(String id) {
        boolean res = companyService.disable(id);
        if (res) {
            tokenClearService.clearByCompanyId(id);
        }
        return res;
    }

    @Override
    public Optional<List<CompanyDO>> queryChildrenByToken() {
        String userId = AuthenticationHelper.localContextHolderParser().getId().orElseThrow(FailResultException::userInfoError);
        UserExtend userExtend = userLinkCompanyService.queryById(userId).orElseGet(UserExtend::new);
        String lastBelongCompanyId = Optional.ofNullable(userExtend.getBelongCompanys()).orElseGet(ArrayList::new)
                .stream()
                .max(Comparator.comparingInt(CompanyDO::getLevel))
                .map(CompanyDO::getId)
                .orElseThrow(() -> new FailResultException("获取归属机构数据失败"));
        return companyService.queryChild(lastBelongCompanyId);
    }

}
