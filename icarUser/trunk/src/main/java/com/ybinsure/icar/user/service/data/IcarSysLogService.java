package com.ybinsure.icar.user.service.data;

import com.ybinsure.icar.user.model.data.IcarSysLogDO;

/**
 * 系统日志服务接口
 *
 * @author HANHT
 * @version 2018/7/12 10:44
 */
public interface IcarSysLogService {

    /**
     * 保存日志
     */
    void saveIcSysLog(IcarSysLogDO log);
}
