package com.ybinsure.icar.user.mapper.wallet;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 钱包
 *
 * @author lic
 * 2018-03-22
 */
@Repository
public interface WalletMapper {

    Map<String, Object> getUserInfoById(@Param("uId") String uId);

    /**
     * 获取的钱包余额
     */
    Map<String, Object> getWalletById(@Param("uId") String uId);

    /**
     * 修改提现的密码
     *
     * @param code 验证码
     * @param pwd  新密码
     */
    int updateWalletPassword(@Param("code") String code, @Param("uId") String uId, @Param("pwd") String pwd);

    /**
     * 设置提现的密码
     *
     * @param pwd 新密码
     */
    int addWalletPassword(@Param("uId") String uId, @Param("pwd") String pwd);

    /**
     * 获取的钱包记录列表
     *
     * @param page 页码，从0开始
     * @param type 0为全部，1为提现，2为收入
     */
    List<Map<String, Object>> getWalletRecord(@Param("page") int page, @Param("row") int row, @Param("uId") String uId, @Param("type") int type);

    /**
     * 检查用户的是否实名验证
     */
    Map<String, Object> checkUserRealNameAuth(@Param("uId") String uId);

    /**
     * 修改，绑定开户账号
     *
     * @param cardType    0为银联卡，1为支付宝，2为微信
     * @param cardNumber  银行卡号,支付宝账号，微信账号
     * @param bankDeposit 开户支行
     * @param bank        开户银行
     */
    int bindWithdrawAccount(@Param("uId") String uId, @Param("accountHolder") String accountHolder, @Param("cardType") String cardType, @Param("cardNumber") String cardNumber, @Param("bankDeposit") String bankDeposit, @Param("bank") String bank);

    /**
     * 提现申请
     *
     * @param amount 金额
     */
    int withdraw(@Param("uId") String uId, @Param("amount") double amount);

    /*	======================对接爱员工系统 以下============*/
    /*
     * 查找该手机号是否已提交签约
     */
    Map<String, Object> checkUserSigned(@Param("uId") String uId, @Param("personalMobile") String personalMobile);

    /**
     * 查询签约的
     */
    Map<String, Object> getUserSignedById(@Param("signOrderNo") String signOrderNo);

    /**
     * 保存签约信息
     */
    int saveUserSignedInfo(Map<String, Object> map);

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

    /**
     * 清空输出密码次数
     */
    int clearPassWordErr(String uid);
}
