package com.ybinsure.icar.user.wallet.service;

import java.util.List;
import java.util.Map;

/**
 * @author lichuan
 */
public interface WalletService {

    /**
     * 用户资料
     */
    Map<String, Object> getUserInfoById(String uId);

    /**
     * 获取的钱包余额
     */
    Map<String, Object> getWalletById(String uId);

    /**
     * 修改提现的密码
     *
     * @param code 验证码
     * @param pwd  新密码
     */
    boolean updateWalletPassword(String code, String uId, String pwd);

    /**
     * 设置提现的密码
     *
     * @param pwd 新密码
     */
    boolean addWalletPassword(String uId, String pwd);

    /**
     * 获取的
     *
     * @param page  页码，从0开始
     * @param count 页的行数
     * @param type  0为全部，1为提现，2为收入
     */
    List<Map<String, Object>> getWalletRecord(int page, int count, String uId, int type);

    /**
     * 检查用户的是否实名验证
     */
    Map<String, Object> checkUserRealNameAuth(String uId);

    /**
     * 修改，绑定开户账号
     *
     * @param cardType    0为银联卡，1为支付宝，2为微信
     * @param cardNumber  银行卡号,支付宝账号，微信账号
     * @param bankDeposit 开户支行
     * @param bank        开户银行
     */
    boolean bindWithdrawAccount(String uId, String accountHolder, String cardType, String cardNumber, String bankDeposit, String bank);

    /**
     * 提现
     *
     * @param amount 金额
     */
    boolean withdraw(String uId, double amount);

    /*
     * 查找该手机号是否已提交签约
     */
    Map<String, Object> checkUserSigned(String uId, String personalMobile);

    /**
     *
     * @param
     * @return
     */
    Map<String, Object> getUserSignedById(String signOrderNo);

    /**
     * 保存签约信息
     */
    int saveUserSignedInfo(Map<String, Object> param);

    /**
     * 更新的签约一下回调信息
     */
    int updateSignedState(Map<String, Object> map);

    /*
     * 工资单笔代发
     */
    int savePayInfo(Map<String, Object> map);

    /**
     * 更新代发的金额状态
     */
    int updatePayInfo(Map<String, Object> map);
}
