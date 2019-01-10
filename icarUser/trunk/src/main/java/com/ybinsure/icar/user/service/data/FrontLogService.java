package com.ybinsure.icar.user.service.data;

import com.ybinsure.icar.user.model.param.FrontParam;

/**
 * 前端错误日志服务
 *
 * @author HANHT
 * @version 2018/7/12 15:40
 */
public interface FrontLogService {

    /**
     * 保存错误日志
     */
    void saveErrorLog(FrontParam param);
}
