package com.ybinsure.icar.user.model.data;

import java.io.Serializable;

/**
 * 操作记录表
 *
 * @author HANHT
 * @version 2018/7/12 10:2
 */
public class IcarSysLogDO implements Serializable {
    private Integer id;

    /** 车牌 */
    private String licenseNo;

    /** 用户ID */
    private String uid;

    /** 用户名 */
    private String name;

    /** 手机号 */
    private Long cell;

    /** 接口描述 */
    private String module;

    /** 接口方法名 */
    private String operate;

    /** 入参json串 */
    private String requestParam;

    /** 访问IP */
    private String clientIp;

    /** 保险公司ID */
    private Integer companyId;

    /** 0为车型查询，1为报价，2为核保，3为申请支付，4承保回调，5为车牌查询 */
    private Integer actionType;

    /** 0为正常，1,为业务异常，2为系统异常 */
    private Byte level;

    /** 业务错误信息，系统报错信息不记录 */
    private String errMsg;

    /** 添加时间 */
    private Long time;

    /** 来源 */
    private String sourceId;

    /** 接口耗时（ms） */
    private Integer runTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo == null ? null : licenseNo.trim();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getCell() {
        return cell;
    }

    public void setCell(Long cell) {
        this.cell = cell;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module == null ? null : module.trim();
    }

    public String getOperate() {
        return operate;
    }

    public void setOperate(String operate) {
        this.operate = operate == null ? null : operate.trim();
    }

    public String getRequestParam() {
        return requestParam;
    }

    public void setRequestParam(String requestParam) {
        this.requestParam = requestParam == null ? null : requestParam.trim();
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp == null ? null : clientIp.trim();
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getActionType() {
        return actionType;
    }

    public void setActionType(Integer actionType) {
        this.actionType = actionType;
    }

    public Byte getLevel() {
        return level;
    }

    public void setLevel(Byte level) {
        this.level = level;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg == null ? null : errMsg.trim();
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId == null ? null : sourceId.trim();
    }

    public Integer getRunTime() {
        return runTime;
    }

    public void setRunTime(Integer runTime) {
        this.runTime = runTime;
    }
}