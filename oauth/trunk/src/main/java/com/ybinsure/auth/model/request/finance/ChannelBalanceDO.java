package com.ybinsure.auth.model.request.finance;

import java.io.Serializable;
import java.math.BigDecimal;

public class ChannelBalanceDO implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column finance_channel_balance.id
     *
     * @mbg.generated
     */
    private String id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column finance_channel_balance.channel_code
     *
     * @mbg.generated
     */
    private String channelCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column finance_channel_balance.balance
     *
     * @mbg.generated
     */
    private BigDecimal balance;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column finance_channel_balance.create_time
     *
     * @mbg.generated
     */
    private Long createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column finance_channel_balance.update_time
     *
     * @mbg.generated
     */
    private Long updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table finance_channel_balance
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column finance_channel_balance.id
     *
     * @return the value of finance_channel_balance.id
     *
     * @mbg.generated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table finance_channel_balance
     *
     * @mbg.generated
     */
    public ChannelBalanceDO withId(String id) {
        this.setId(id);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column finance_channel_balance.id
     *
     * @param id the value for finance_channel_balance.id
     *
     * @mbg.generated
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column finance_channel_balance.channel_code
     *
     * @return the value of finance_channel_balance.channel_code
     *
     * @mbg.generated
     */
    public String getChannelCode() {
        return channelCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table finance_channel_balance
     *
     * @mbg.generated
     */
    public ChannelBalanceDO withChannelCode(String channelCode) {
        this.setChannelCode(channelCode);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column finance_channel_balance.channel_code
     *
     * @param channelCode the value for finance_channel_balance.channel_code
     *
     * @mbg.generated
     */
    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode == null ? null : channelCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column finance_channel_balance.balance
     *
     * @return the value of finance_channel_balance.balance
     *
     * @mbg.generated
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table finance_channel_balance
     *
     * @mbg.generated
     */
    public ChannelBalanceDO withBalance(BigDecimal balance) {
        this.setBalance(balance);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column finance_channel_balance.balance
     *
     * @param balance the value for finance_channel_balance.balance
     *
     * @mbg.generated
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column finance_channel_balance.create_time
     *
     * @return the value of finance_channel_balance.create_time
     *
     * @mbg.generated
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table finance_channel_balance
     *
     * @mbg.generated
     */
    public ChannelBalanceDO withCreateTime(Long createTime) {
        this.setCreateTime(createTime);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column finance_channel_balance.create_time
     *
     * @param createTime the value for finance_channel_balance.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column finance_channel_balance.update_time
     *
     * @return the value of finance_channel_balance.update_time
     *
     * @mbg.generated
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table finance_channel_balance
     *
     * @mbg.generated
     */
    public ChannelBalanceDO withUpdateTime(Long updateTime) {
        this.setUpdateTime(updateTime);
        return this;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column finance_channel_balance.update_time
     *
     * @param updateTime the value for finance_channel_balance.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}