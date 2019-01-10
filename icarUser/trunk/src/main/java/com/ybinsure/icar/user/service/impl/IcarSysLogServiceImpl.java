package com.ybinsure.icar.user.service.impl;

import com.ybinsure.icar.user.mapper.data.IcarSysLogDOMapper;
import com.ybinsure.icar.user.model.data.IcarSysLogDO;
import com.ybinsure.icar.user.service.data.IcarSysLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 系统日志服务接口实现
 *
 * @author HANHT
 * @version 2018/7/12 10:45
 */
@Service
public class IcarSysLogServiceImpl implements IcarSysLogService {

    private static final Logger logger = LoggerFactory.getLogger(IcarSysLogServiceImpl.class);

    private final IcarSysLogDOMapper icarSysLogDOMapper;

    @Autowired
    public IcarSysLogServiceImpl(IcarSysLogDOMapper icarSysLogDOMapper) {
        this.icarSysLogDOMapper = icarSysLogDOMapper;
    }

    @Override
    public void saveIcSysLog(IcarSysLogDO log) {
        try {
            icarSysLogDOMapper.insertSelective(log);
        } catch (Exception e) {
            logger.error("添加日志失败：{}", e.getMessage());
        }
    }
}
