package com.ybinsure.auth.service.tool;

import java.util.List;

/**
 * 基于时间的序列号服务
 */
public interface TimeSequenceService {

    String USER_TYPE = "user";
    String COMPANY_TYPE = "company";

    /**
     * 获取分类的业务编码
     * @param type 分类字符
     * @return 业务编码
     */
    String getNextSequence(String type);

    /**
     * 查询分类的多个业务编码
     * @param type 分类字符
     * @param step 业务编码数量
     * @return 业务编码
     */
    List<String> getStepSequence(String type, Long step);
}
