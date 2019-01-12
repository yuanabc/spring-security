package com.ybinsure.auth.model.link;

import com.ybinsure.auth.model.data.ClientDO;
import com.ybinsure.auth.model.data.PropertyDO;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClientExtend extends ClientDO {

    private List<PropertyDO> grantTypes;
    private List<PropertyDO> resources;
    private List<PropertyDO> scopes;

    public ClientExtend() {
    }

    public List<PropertyDO> getGrantTypes() {
        return grantTypes;
    }

    public void setGrantTypes(List<PropertyDO> grantTypes) {
        this.grantTypes = grantTypes;
    }

    public List<PropertyDO> getResources() {
        return resources;
    }

    public void setResources(List<PropertyDO> resources) {
        this.resources = resources;
    }

    public List<PropertyDO> getScopes() {
        return scopes;
    }

    public void setScopes(List<PropertyDO> scopes) {
        this.scopes = scopes;
    }

    public ClientDetails getClientDetails() {
        BaseClientDetails clientDetails = new BaseClientDetails();
        clientDetails.setClientId(getClient());
        clientDetails.setClientSecret(getPassword());
        clientDetails.setResourceIds(getResources(resources));
        clientDetails.setScope(getResources(scopes));
        clientDetails.setAuthorizedGrantTypes(getResources(grantTypes));
        clientDetails.setRefreshTokenValiditySeconds(getAccessTokenExpiriTime());
        clientDetails.setAccessTokenValiditySeconds(getRefreshTokenExpiriTime());
        return clientDetails;
    }

    private Set<String> getResources(List<PropertyDO> propertyDOS) {
        Set<String> result = new HashSet<>();
        propertyDOS.forEach(property -> result.add(property.getValue1()));
        return result;
    }
}
