package com.ybinsure.auth.model.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ybinsure.auth.annotation.validator.UpdateAction;
import com.ybinsure.auth.constant.CompanyLinkTypeCode;
import com.ybinsure.auth.constant.CompanyTypeCode;
import com.ybinsure.auth.model.data.base.BaseUserDO;
import com.ybinsure.auth.model.transfer.tree.TreeNode;
import com.ybinsure.auth.util.AuthenticationHelper;
import com.ybinsure.auth.util.EncryptionUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.switchuser.SwitchUserGrantedAuthority;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@ApiModel(description = "用户数据")
@Setter
@Getter
public class UserDO extends BaseUserDO implements Serializable {

    @NotBlank(groups = {UpdateAction.class}, message = "id不能为空")
    @ApiModelProperty(value = "数据主键")
    private String id;

    @ApiModelProperty(value = "业务主键编码")
    private String sequence;

    @ApiModelProperty(value = "业务主键编码")
    private Long code;

    @ApiModelProperty(value = "老数据的主键")
    private Integer oldId;

    @NotBlank(
            groups = {InsertAdminAction.class, InsertUserAction.class, VerifyCaptchaWithUserName.class},
            message = "userName不能为空")
    @ApiModelProperty(value = "用户名")
    private String userName;

    @NotBlank(
            groups = {InsertAdminAction.class, InsertUserAction.class},
            message = "nickName不能为空")
    @ApiModelProperty(value = "昵称")
    private String nickName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(
            groups = {VerifyCaptchaWithUserName.class, VerifyCaptchaWithPhone.class},
            message = "password不能为空")
    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "性别, 1-男性, 2-女性")
    private String sex;

    @NotBlank(
            groups = {InsertSaleAction.class, InsertChannelSalesAction.class},
            message = "idName不能为空")
    @ApiModelProperty(value = "证件名称")
    private String idName;

    @NotBlank(
            groups = {InsertAdminAction.class, InsertUserAction.class, InsertSaleAction.class, VerifyCaptchaWithPhone.class, Verify.class},
            message = "phone不能为空")
    @ApiModelProperty(value = "联系电话")
    private String phone;

    @ApiModelProperty(value = "证件号码")
    private String idNo;

    @ApiModelProperty(value = "渠道内部工号")
    private String agentCode;

    @ApiModelProperty(value = "用户分类, 1-管理员, 2-内勤人员, 3-业务员")
    private String userType;

    @NotBlank(groups = {InsertSaleAction.class}, message = "salesType不能为空")
    @ApiModelProperty(value = "业务员分类, 1-普通业务员，2-渠道业务员")
    private String salesType;

    @ApiModelProperty(value = "管辖机构是否是默认归属机构")
    private Byte defaultManagerCompany;

    @ApiModelProperty(value = "开户银行")
    private String bank;

    @ApiModelProperty(value = "开户人")
    private String accountHolder;

    @ApiModelProperty(value = "银行预留号码")
    private String bankPhone;

    @ApiModelProperty(value = "银行卡号")
    private String bankNo;

    @ApiModelProperty(value = "备注信息")
    private String description;

    @ApiModelProperty(value = "渠道内部状态")
    private Byte channelStatus;

    @ApiModelProperty(value = "逻辑删除状态")
    private Byte deleted;

    @NotNull(
            groups = {InsertAdminAction.class, InsertUserAction.class, InsertSaleAction.class, InsertChannelSalesAction.class},
            message = "status不能为空")
    @ApiModelProperty(value = "禁用状态")
    private Byte status;

    @NotBlank(
            groups = {InsertAdminAction.class, InsertUserAction.class, InsertSaleAction.class, InsertChannelSalesAction.class, Verify.class},
            message = "channelCode不能为空")
    @ApiModelProperty(value = "渠道编码")
    private String channelCode;

    @ApiModelProperty(value = "老数据权限")
    private Byte power;

    @ApiModelProperty(value = "老数据，卡的分类")
    private Byte cardType;

    @ApiModelProperty(value = "可提现的钱包")
    private Double wallet;

    @ApiModelProperty(value = "钱包提现密码")
    private String withDrawPwd;

    @ApiModelProperty(value = "老数据，分类")
    private Byte type;

    @ApiModelProperty(value = "营业执照")
    private String saleNo;

    @ApiModelProperty(value = "森瑞 en码")
    private String enNo;

    @ApiModelProperty(value = "深保通姓名")
    private String sbtAppName;

    @ApiModelProperty(value = "深保通密码")
    private String sbtPassword;

    @ApiModelProperty(value = "深保通账号")
    private String sbtAppIdNo;

    @ApiModelProperty(value = "更新时间")
    private Long updateTime;

    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    @JsonIgnore
    @ApiModelProperty(value = "最后token过期时间")
    private Date lastTokenExpireTime;

    @JsonIgnore
    @ApiModelProperty(value = "最后token")
    private String lastToken;

    @ApiModelProperty(value = "第一层机构")
    private String company0;

    @ApiModelProperty(value = "第二层机构")
    private String company1;

    @ApiModelProperty(value = "第三层机构")
    private String company2;

    @ApiModelProperty(value = "第四层机构")
    private String company3;

    @ApiModelProperty(value = "第五层机构")
    private String company4;

    @ApiModelProperty(value = "第六层机构")
    private String company5;

    @ApiModelProperty(value = "第七层机构")
    private String company6;

    private static final long serialVersionUID = 1L;

    /**
     * 获取手机后六位作为密码
     */
    @JsonIgnore
    public Optional<String> getMd5PasswordWithPhone() {
        return getPasswordWithPhone().map(EncryptionUtil::md5);
    }

    @JsonIgnore
    public Optional<String> getPasswordWithPhone() {
        if (StringUtils.isBlank(getPhone()) || getPhone().length() < 8) {
            return Optional.empty();
        }
        String sourcePassword = getPhone().substring(getPhone().length() - 8);
        return Optional.of(sourcePassword);
    }

    public TreeNode convertTreeNode() {
        TreeNode treeNode = new TreeNode();
        treeNode.setKey(getId());
        treeNode.setTitle(getIdName());
        return treeNode;
    }

    @JsonIgnore
    public User getUserDetails(List<GrantedAuthority> authorities) {
        List<GrantedAuthority> normalAuthorities = getPermission();
        normalAuthorities.addAll(authorities);
        return new User(getUserName(), getPassword(), normalAuthorities);
    }

    @JsonIgnore
    private List<GrantedAuthority> getPermission() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (PermissionDO item : getPermissionDOS()) {
            authorities.add(new SimpleGrantedAuthority(item.getCode()));
        }
        // 添加人员信息
        authorities.add(new SwitchUserGrantedAuthority(AuthenticationHelper.customInfoRole, getAuthenticationInfo()));
        return authorities;
    }

    @JsonIgnore
    private Authentication getAuthenticationInfo() {
        String lastBelongCompanyId = Optional.ofNullable(getBelongCompanys()).orElseGet(ArrayList::new)
                .stream().max(Comparator.comparingInt(CompanyDO::getLevel)).map(CompanyDO::getId).orElse("");
        Map<String, String> principal = new HashMap<>();
        principal.put(AuthenticationHelper.id, getId());
        principal.put(AuthenticationHelper.channelCode, getChannelCode());
        principal.put(AuthenticationHelper.nickName, getNickName());
        principal.put(AuthenticationHelper.idName, getIdName());
        principal.put(AuthenticationHelper.phone, getPhone());
        principal.put(AuthenticationHelper.belongCompanyId, lastBelongCompanyId);
        return new UsernamePasswordAuthenticationToken(principal, null);
    }

    @JsonIgnore
    public Optional<CompanyDO> getTeamCompany() {
        return Optional.ofNullable(getBelongCompanys())
                .flatMap(companyDOS -> companyDOS.stream()
                        .filter(companyDO -> StringUtils.equals(companyDO.getCompanyType(), CompanyTypeCode.TEAM))
                        .findAny()
                );
    }

    /**
     * company数据分类到belongCompany和managerCompany
     */
    public void setBelongCompanyAndManagerCompany() {
        List<CompanyDO> companies = getCompanyDOS();
        List<UserRelateCompanyDO> userRelateCompanies = getUserRelateCompanyDOS();
        if (companies == null || companies.isEmpty() || userRelateCompanies == null || userRelateCompanies.isEmpty()) {
            return;
        }
        // 过滤归属机构
        Predicate<CompanyDO> filterBelongCompanyPredicate = companyDO ->
                userRelateCompanies.stream()
                        .anyMatch(userRelateCompanyDO -> StringUtils.equals(userRelateCompanyDO.getCompanyId(), companyDO.getId()) &&
                                StringUtils.equals(userRelateCompanyDO.getLinkType(), CompanyLinkTypeCode.BELONG));
        List<CompanyDO> belongCompany = companies.stream()
                .filter(filterBelongCompanyPredicate)
                .sorted((c1 ,c2) -> c2.getLevel() - c1.getLevel())
                .limit(1)
                .collect(Collectors.toList());
        setBelongCompanys(belongCompany);
        // 过滤管辖机构
        Predicate<CompanyDO> filterManagerCompanyPredicate = companyDO ->
                userRelateCompanies.stream()
                        .anyMatch(userRelateCompanyDO -> StringUtils.equals(userRelateCompanyDO.getCompanyId(), companyDO.getId()) &&
                                StringUtils.equals(userRelateCompanyDO.getLinkType(), CompanyLinkTypeCode.MANAGER));
        List<CompanyDO> managerCompany = companies.stream()
                .filter(filterManagerCompanyPredicate)
                .collect(Collectors.toList());
        setManagerCompanys(managerCompany);
        // 清空company
        setCompanyDOS(null);
        setUserRelateCompanyDOS(null);
    }

    public void setCompanyIds(List<CompanyDO> companies) {
        if (companies != null && !companies.isEmpty()) {
            companies.forEach(this::setCompanyId);
            setCompanyEmpty();
        }
    }

    private void setCompanyId(CompanyDO companyDO) {
        switch (companyDO.getLevel()) {
            case 0:
                setCompany0(companyDO.getId());
                break;
            case 1:
                setCompany1(companyDO.getId());
                break;
            case 2:
                setCompany2(companyDO.getId());
                break;
            case 3:
                setCompany3(companyDO.getId());
                break;
            case 4:
                setCompany4(companyDO.getId());
                break;
            case 5:
                setCompany5(companyDO.getId());
                break;
            case 6:
                setCompany6(companyDO.getId());
                break;
                default:
                    // 不做处理
        }
    }

    private void setCompanyEmpty() {
        if (StringUtils.isBlank(getCompany0())) {
            setCompany0("");
        }
        if (StringUtils.isBlank(getCompany1())) {
            setCompany1("");
        }
        if (StringUtils.isBlank(getCompany2())) {
            setCompany2("");
        }
        if (StringUtils.isBlank(getCompany3())) {
            setCompany3("");
        }
        if (StringUtils.isBlank(getCompany4())) {
            setCompany4("");
        }
        if (StringUtils.isBlank(getCompany5())) {
            setCompany5("");
        }
        if (StringUtils.isBlank(getCompany6())) {
            setCompany6("");
        }
    }

    public interface InsertAdminAction {}
    public interface InsertUserAction {}
    public interface InsertSaleAction {}
    public interface InsertSalesWithWebAction {}
    public interface InsertChannelSalesAction {}
    public interface VerifyCaptchaWithUserName {}
    public interface VerifyCaptchaWithPhone {}
    public interface Verify{}
}