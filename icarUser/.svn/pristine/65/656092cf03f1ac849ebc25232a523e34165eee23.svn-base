package com.ybinsure.icar.user.aspect;

import com.fasterxml.jackson.databind.JsonNode;
import com.ybinsure.icar.user.annotation.ControllerLog;
import com.ybinsure.icar.user.auth.AuthenticationHelper;
import com.ybinsure.icar.user.constant.CacheKey;
import com.ybinsure.icar.user.constant.RespInfo;
import com.ybinsure.icar.user.exception.SystemException;
import com.ybinsure.icar.user.model.ICarResult;
import com.ybinsure.icar.user.model.data.IcarSysLogDO;
import com.ybinsure.icar.user.service.data.IcarSysLogService;
import com.ybinsure.icar.user.util.JsonUtil;
import com.ybinsure.icar.user.util.RequestParamsUtil;
import com.ybinsure.icar.user.util.StrUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 日志拦截器
 *
 * @author HANHT
 * @version 2018/6/13 11:37
 */
@Order(1)
@Aspect
@Component
public class LogAspect {

    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

    @Autowired
    private IcarSysLogService logService;

    @Pointcut("@annotation(com.ybinsure.icar.user.annotation.ControllerLog)")
    public void controllerAspect() {
    }

    /**
     * 此方法必须有返回值，否则会使得被代理的方法的返回值变为null，在此方法中可以修改返回值
     */
    @Around("controllerAspect()")
    public Object aroundController(ProceedingJoinPoint joinPoint) throws Throwable {
        // 调用类全称
        String className = joinPoint.getSignature().getDeclaringTypeName();
        // 调用方法名
        String methodName = joinPoint.getSignature().getName();
        // 获取请求request
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        // 请求URL
        String requestURI = request.getRequestURI();
        logger.info("请求URL：{}", requestURI);
        // 获取请求参数
        Map<String, String> requestMap = RequestParamsUtil.getRequestMap(request);
        // 请求参数JSON串
        String requestJson = JsonUtil.toJson(requestMap).orElse("");
        logger.info("请求参数：{}", requestJson);
        // 获取方法注解信息
        Map<String, Object> describe = getControllerMethodDescription(joinPoint);
        logger.info("请求描述：{}", describe);

        // 方法参数
        Object[] args = joinPoint.getArgs();
        // 请求结果
        Object result;
        // 方法调用开始时间/总耗时
        long start = System.currentTimeMillis(), runTime;
        try {
            logger.info("请求开始于：{}.{}", className, methodName);

            // 请求具体方法
            result = joinPoint.proceed(args);

            runTime = System.currentTimeMillis() - start;
            logger.info("请求成功：{}.{}，耗时：{}ms", className, methodName, runTime);

            // 记录成功日志
            printLog(methodName, requestJson, describe, result, 0, runTime);
        } catch (Throwable throwable) {
            runTime = System.currentTimeMillis() - start;
            logger.info("请求异常：{}.{}，耗时：{}ms", className, methodName, runTime);
            // 获取线程堆栈信息
            String msg = throwable.getMessage();
            logger.info("请求异常信息：{}", msg);
            // 记录异常日志
            printLog(methodName, requestJson, describe, msg, 2, runTime);

            throw throwable;
        }

        logger.info("{}接口响应数据：{}", describe.getOrDefault("description", ""), JsonUtil.toJson(result).orElse(""));

        return result;
    }

    /**
     * 日志信息入库
     */
    private void printLog(String methodName, String requestJson, Map<String, Object> describe, Object result, int level, long runTime) {
        try {
            generateSysLog(requestJson, describe, result, methodName, level, runTime);
        } catch (Exception ex) {
            logger.error("系统日志保存异常：{}", ex.getMessage());
        }
    }

    /**
     * 组装日志对象
     */
    private void generateSysLog(String requestJson, Map<String, Object> describe, Object result, String methodName, int level, long runTime) {
        IcarSysLogDO log = new IcarSysLogDO();
        log.setModule(String.valueOf(describe.get("description")));
        log.setOperate(methodName);
        log.setRequestParam(requestJson);

        // 存日志线程号
        log.setClientIp(MDC.get(CacheKey.LOG));

        // 取出车牌号
        JsonNode json = JsonUtil.readJson(requestJson).orElseThrow(SystemException::exception);
        final String licenseNo = "carLicense";
        if (json.has(licenseNo)) {
            log.setLicenseNo(json.path(licenseNo).asText());
        }

        // 获取用户id
        String userId = AuthenticationHelper.getId().orElse("");

        // 异常信息
        if (StrUtil.isNotNull(result)) {
            // 错误信息
            String msg;
            // 正常返回
            if (level == 0) {
                // 接口返回
                String[] res = getMsg(result, userId);

                level = StrUtil.toInt(res[0], 0);
                if (StrUtil.isBlank(userId)) {
                    userId = res[1];
                }

                msg = res[2];
            } else {
                msg = String.valueOf(result);
            }

            // 控制错误日志的长度：500
            msg = StrUtil.substring(msg, 500);

            log.setErrMsg(msg);
        }

        log.setLevel(StrUtil.toByte(level, 0));

        // 用户信息
        if (StrUtil.isNotBlank(userId)) {
            log.setUid(userId);

            log.setName(AuthenticationHelper.getIdName().orElse(""));
            log.setCell(StrUtil.toLong(AuthenticationHelper.getUserName().orElse(""), 0));
            log.setSourceId(AuthenticationHelper.getChannelCode().orElse(""));
        }

        log.setTime(System.currentTimeMillis());

        // log.setActionType((Integer) describe.get("actionType"));

        // 记录接口耗时
        log.setRunTime(StrUtil.toInt(runTime, 0));

        // 保存入库
        logService.saveIcSysLog(log);
    }

    /**
     * 获取异常信息
     * [level, userid, msg]
     */
    private String[] getMsg(Object result, String userId) {
        String level = "0", msg = "";
        if (result instanceof ICarResult) {
            ICarResult res = (ICarResult) result;
            // 返回状态
            int status = res.getStatus();
            // 异常
            if (status != RespInfo.SUCCESS.code) {
                level = "1";

                msg = RespInfo.matchMsg(status);
            }
        } else {
            msg = result.toString();
        }

        return new String[]{level, userId, msg};
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     */
    private static Map<String, Object> getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        Class targetClass = Class.forName(joinPoint.getTarget().getClass().getName());
        Method[] methods = targetClass.getMethods();

        // 方法注解描述信息
        Map<String, Object> describe = new HashMap<>(2);

        Optional<Method> methodOptional = Arrays.stream(methods).filter(method -> method.getName().equals(joinPoint.getSignature().getName())).findFirst();
        if (methodOptional.isPresent()) {
            Method method = methodOptional.get();
            // 方法注解描述
            String description = method.getAnnotation(ControllerLog.class).description();
            // 方法类型
            int actionType = method.getAnnotation(ControllerLog.class).actionType();

            describe.put("description", description);
            describe.put("actionType", actionType);
        }

        return describe;
    }
}
