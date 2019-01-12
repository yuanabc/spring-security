package com.ybinsure.auth.model.data;

import com.ybinsure.auth.model.data.base.BaseClientDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ApiModel(description = "客户端数据")
@Setter
@Getter
public class ClientDO extends BaseClientDO implements Serializable {

    @ApiModelProperty(value = "主键id")
    private String id;

    @ApiModelProperty(value = "用户名")
    private String client;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "描述信息")
    private String description;

    @ApiModelProperty(value = "状态，0-可用， 1-不可用")
    private Byte status;

    @ApiModelProperty(value = "该客户端是否重置过期时间")
    private Byte reset;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    @ApiModelProperty(value = "更新时间")
    private Long updateTime;

    @ApiModelProperty(value = "refreshToken过期时间")
    private Integer refreshTokenExpiriTime;

    @ApiModelProperty(value = "accessToken过期时间")
    private Integer accessTokenExpiriTime;

    private static final long serialVersionUID = 1L;

    public ClientDetails getClientDetails() {
        BaseClientDetails clientDetails = new BaseClientDetails();
        clientDetails.setClientId(getClient());
        clientDetails.setClientSecret(getPassword());
        clientDetails.setResourceIds(getResources(this.getResources()));
        clientDetails.setScope(getResources(getScopes()));
        clientDetails.setAuthorizedGrantTypes(getResources(getGrantTypes()));
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