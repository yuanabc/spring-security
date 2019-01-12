package com.ybinsure.auth.model.link;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ybinsure.auth.model.data.CompanyDO;
import com.ybinsure.auth.model.data.WebConfigDO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public class CompanyLinkWebConfig {

    @Valid
    @NotNull
    @JsonProperty("company")
    private CompanyDO companyDO;

    @NotNull
    @JsonProperty("webConfigs")
    private List<WebConfigDO> webConfigDOS;

    public CompanyLinkWebConfig() {
    }

    public CompanyDO getCompanyDO() {
        return companyDO;
    }

    public void setCompanyDO(CompanyDO companyDO) {
        this.companyDO = companyDO;
    }

    public List<WebConfigDO> getWebConfigDOS() {
        return webConfigDOS;
    }

    public void setWebConfigDOS(List<WebConfigDO> webConfigDOS) {
        this.webConfigDOS = webConfigDOS;
    }
}
