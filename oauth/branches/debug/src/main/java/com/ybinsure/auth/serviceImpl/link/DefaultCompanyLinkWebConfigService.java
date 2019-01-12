package com.ybinsure.auth.serviceImpl.link;

import com.ybinsure.auth.model.link.CompanyLinkWebConfig;
import com.ybinsure.auth.service.data.CompanyService;
import com.ybinsure.auth.service.data.WebConfigService;
import com.ybinsure.auth.service.link.CompanyLinkWebConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultCompanyLinkWebConfigService implements CompanyLinkWebConfigService {

    private final CompanyService companyService;
    private final WebConfigService webConfigService;

    @Override
    @Transactional
    public Optional<String> insert(CompanyLinkWebConfig param) {
        Optional<String> insertCompanyResult = companyService.insert(param.getCompanyDO());
        if (!insertCompanyResult.isPresent()) {
            return Optional.empty();
        }
        param.getWebConfigDOS().forEach(webConfigDo -> webConfigDo.setValue(insertCompanyResult.get()));
        webConfigService.deleteAndInsertList(param.getWebConfigDOS());
        return insertCompanyResult;
    }

    @Override
    @Transactional
    public boolean update(CompanyLinkWebConfig param) {
        if (!companyService.update(param.getCompanyDO())) {
            return false;
        }
        param.getWebConfigDOS().forEach(webConfigDo -> webConfigDo.setValue(param.getCompanyDO().getId()));
        webConfigService.deleteAndInsertList(param.getWebConfigDOS());
        return true;
    }
}
