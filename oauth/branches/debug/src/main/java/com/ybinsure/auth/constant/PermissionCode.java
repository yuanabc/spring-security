package com.ybinsure.auth.constant;

/**
 * 权限项编码
 */
public interface PermissionCode {

    /**
     * 管理员
     */
    String admin = "0000000001"; // 管理员渠道

    /**
     * 组织机构
     */
    String group = "0010000000"; // 组织机构
    String companyManager = "0010100000"; // 机构管理
    String companyManagerS = "0010101000"; // 机构管理-查看
    String companyManagerSDefault = "0010101010"; // 机构管理-查看-筛选查看
    String companyManagerA = "0010102000"; // 新增
    String companyManagerADefault = "0010102010"; // 添加机构
    String companyManagerU = "0010103000"; // 修改
    String companyManagerUDisable = "0010103010"; // 启用禁用
    String companyManagerUEdit = "0010103020"; // 编辑机构
    String companyManagerD = "0010104000"; // 删除
    String companyManagerDDefault = "0010104010"; // 删除机构

    // 个人业务员
    String personSales = "0010200000"; // 个人业务员
    String personSalesS = "0010201000"; // 查看
    String personSalesSDefault = "0010201010"; // 筛选查找
    String personSalesA = "0010202000"; // 新增
    String personSalesADefault = "0010202010"; // 添加业务员
    String personSalesU = "0010203000"; // 修改
    String personSalesUEdit = "0010203010"; // 编辑业务员
    String personSalesUDisable = "0010203020"; // 启用禁用
    String personSalesUReset = "0010203030"; // 重置密码
    String personSalesD = "0010204000"; // 删除
    String personSalesDDefault = "0010204010"; // 删除业务员

    // 渠道业务员
    String channelSales = "0010300000"; // 渠道业务员
    String channelSalesS = "0010301000"; // 查看
    String channelSalesSDefault = "0010301010"; // 筛选查找
    String channelSalesA = "0010302000"; // 新增
    String channelSalesADefault = "0010302010"; // 添加业务员
    String channelSalesU = "0010303000"; // 修改
    String channelSalesUDisable = "0010303010"; // 启用禁用
    String channelSalesUEdit = "0010303020"; // 编辑业务员
    String channelSalesD = "0010304000"; // 删除
    String channelSalesDDefault = "0010304010"; // 删除业务员

    /**
     * 系统管理
     */
    String system = "0020000000"; // 系统管理
    String accountManager = "0020100000"; // 账号管理
    String accountManagerS = "0020101000"; // 查看
    String accountManagerSDefault = "0020101010"; // 筛选查找
    String accountManagerA = "0020102000"; // 新增
    String accountManagerADefault = "0020102010"; // 添加账号
    String accountManagerU = "0020103000"; // 修改
    String accountManagerUDisable = "0020103010"; // 启用禁用账号
    String accountManagerUReset = "0020103020"; // 重置账号密码
    String accountManagerUEdit = "0020103030"; // 编辑账号
    String accountManagerD = "0020104000"; // 删除
    String accountManagerDDefault = "0020104010"; // 删除账号

    /**
     * 运维管理
     */
    String ops = "0030000000"; // 运维管理
    String channelManager = "0030100000"; // 渠道管理
    String channelManagerS = "0030101000"; // 查看
    String channelManagerSDefault = "0030101010"; // 筛选查看
    String channelManagerA = "0030102000"; // 新增
    String channelManagerADefault = "0030102010"; // 添加渠道
    String channelManagerU = "0030103000"; // 修改
    String channelManagerUDisable = "0030103010"; // 启用禁用
    String channelManagerUEdit = "0030103020"; // 编辑渠道
    String channelManagerUReset = "0030103030"; // 重置管理员密码
    String channelManagerD = "0030104000"; // 删除
    String channelManagerDDefault = "0030104010"; // 删除渠道

}
