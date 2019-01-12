package com.ybinsure.auth.model.data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ybinsure.auth.annotation.UpdateAction;
import com.ybinsure.auth.model.data.base.BaseUserDO;
import com.ybinsure.auth.model.link.UserExtend;
import com.ybinsure.auth.model.tool.CaptchaUser;
import com.ybinsure.auth.model.transfer.tree.TreeNode;
import com.ybinsure.auth.util.EncryptionUtil;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

@Setter
@Getter
public class UserDO extends BaseUserDO implements Serializable {

    @NotBlank(groups = {UpdateAction.class}, message = "id不能为空")
    private String id;

    private Long code;

    private Integer oldId;

    @NotBlank(
            groups = {
                    UserExtend.InsertAdminAction.class,
                    UserExtend.InsertUserAction.class,
                    CaptchaUser.VerifyCaptchaWithUserName.class
            },
            message = "userName不能为空")
    private String userName;

    @NotBlank(
            groups = {
                    UserExtend.InsertAdminAction.class,
                    UserExtend.InsertUserAction.class
            },
            message = "nickName不能为空")
    private String nickName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(
            groups = {
                    CaptchaUser.VerifyCaptchaWithUserName.class,
                    CaptchaUser.VerifyCaptchaWithPhone.class
            },
            message = "password不能为空")
    private String password;

    private String sex;

    @NotBlank(
            groups = {
                    UserExtend.InsertSaleAction.class,
                    UserExtend.InsertChannelSalesAction.class
            },
            message = "idName不能为空")
    private String idName;

    @NotBlank(
            groups = {
                    UserExtend.InsertAdminAction.class,
                    UserExtend.InsertUserAction.class,
                    UserExtend.InsertSaleAction.class,
                    CaptchaUser.VerifyCaptchaWithPhone.class,
                    CaptchaUser.Verify.class
            },
            message = "phone不能为空")
    private String phone;

    private String idNo;

    private String agentCode;

    private String userType;

    private String salesType;

    private Byte defaultManagerCompany;

    private String bank;

    private String accountHolder;

    private String bankPhone;

    private String bankNo;

    private String description;

    private Byte channelStatus;

    private Byte deleted;

    @NotNull(
            groups = {
                    UserExtend.InsertAdminAction.class,
                    UserExtend.InsertUserAction.class,
                    UserExtend.InsertSaleAction.class,
                    UserExtend.InsertChannelSalesAction.class
            },
            message = "status不能为空")
    private Byte status;

    @NotBlank(
            groups = {
                    UserExtend.InsertAdminAction.class,
                    UserExtend.InsertUserAction.class,
                    UserExtend.InsertSaleAction.class,
                    UserExtend.InsertChannelSalesAction.class,
                    CaptchaUser.Verify.class
            },
            message = "channelCode不能为空")
    private String channelCode;

    private Byte power;

    private Byte cardType;

    private Double wallet;

    private String withDrawPwd;

    private Byte type;

    private String saleNo;

    private String enNo;

    private String sbtAppName;

    private String sbtPassword;

    private String sbtAppIdNo;

    private Long updateTime;

    private Long createTime;

    @JsonIgnore
    private Date lastTokenExpireTime;

    @JsonIgnore
    private String lastToken;

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
}