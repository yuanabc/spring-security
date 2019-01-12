package com.ybinsure.auth.constant;

/**
 * 权限项编码
 */
public interface PermissionCode {

    String tipPrefix = "需要权限: ";

    // 管理员
    String admin = "'0000000001'"; // 管理员渠道

    // 组织机构
    String companyInsert = "'0010102010'"; // 添加机构
    String companyDisable = "'0010103010'"; // 启用禁用
    String companyEdit = "'0010103020'"; // 编辑机构
    String companyDelete = "'0010104010'"; // 删除机构

    // 角色管理
    String roleInsert = "'0020202010'"; // 添加角色
    String roleDisable = "'0020203010'"; // 启用禁用角色
    String roleEdit = "'0020203020'"; // 修改角色
    String roleDelete = "'0020204010'"; // 删除角色

    // 个人业务员
    String personSalesInsert = "'0010202010'"; // 添加业务员
    String personSalesEdit = "'0010203010'"; // 编辑业务员
    String personSalesDisable = "'0010203020'"; // 启用禁用
    String personSalesReset = "'0010203030'"; // 重置密码
    String personSalesDelete = "'0010204010'"; // 删除业务员

    // 渠道业务员
    String channelSalesInsert = "'0010302010'"; // 添加业务员
    String channelSalesDisable = "'0010303010'"; // 启用禁用
    String channelSalesEdit = "'0010303020'"; // 编辑业务员
    String channelSalesDelete = "'0010304010'"; // 删除业务员

    // 账户
    String accountInsert = "'0020102010'"; // 添加账号
    String accountDisable = "'0020103010'"; // 启用禁用账号
    String accountReset = "'0020103020'"; // 重置账号密码
    String accountEdit = "'0020103030'"; // 编辑账号
    String accountDelete = "'0020104010'"; // 删除账号

    // 渠道管理
    String channelInsert = "'0030102010'"; // 添加渠道
    String channelDisable = "'0030103010'"; // 启用禁用
    String channelEdit = "'0030103020'"; // 编辑渠道
    String channelDelete = "'0030104010'"; // 删除渠道

}
