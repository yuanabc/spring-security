package com.ybinsure.icar.user.exception;

import com.ybinsure.icar.user.constant.RespInfo;
import com.ybinsure.icar.user.model.ICarResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 全局处理抛出的异常
 *
 * @author HANHT
 * @version 2018/7/11 9:47
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 登录认证
     */
    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ICarResult failResultExceptionHandler(AuthenticationException exception) {

        return ICarResult.build(RespInfo.F401);
    }

    /**
     * application/x-www-form-urlencoded
     * 入参校验异常
     */
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.OK)
    public ICarResult failResultExceptionHandler(BindException exception) {
        BindingResult result = exception.getBindingResult();

        return convertException(result);
    }

    /**
     * application/json
     * 入参校验异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    public ICarResult methodExceptionHandler(MethodArgumentNotValidException exception) {
        BindingResult result = exception.getBindingResult();

        return convertException(result);
    }

    /**
     * 转义异常结果
     */
    private ICarResult convertException(BindingResult result) {
        final List<FieldError> fieldErrors = result.getFieldErrors();

        // 返回错误字段和提示
        Map<String, String> fieldMessageMap = new HashMap<>(16);

        for (FieldError error : fieldErrors) {
            fieldMessageMap.put(error.getField(), error.getDefaultMessage());
        }

        return ICarResult.build(RespInfo.ERROR, fieldMessageMap);
    }

    /**
     * 入参格式转换异常
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.OK)
    public ICarResult methodExceptionHandler(HttpMessageNotReadableException exception) {
        logger.error("{}：{}", RespInfo.ERROR.msg, exception.getMessage());
        return ICarResult.build(RespInfo.ERROR);
    }

    /**
     * 参数校验
     * 自定义系统异常返回
     * 异常结果，需要中断流程
     *
     * @param exception 捕捉的异常实例
     * @return 响应结果
     */
    @ExceptionHandler({FailResultException.class, IllegalArgumentException.class})
    @ResponseStatus(HttpStatus.OK)
    public ICarResult exceptionHandler(RuntimeException exception) {
        return ICarResult.build(RespInfo.FAIL.code, exception.getMessage());
    }

    /**
     * Method Not Allowed
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.OK)
    public ICarResult exceptionHandler(HttpRequestMethodNotSupportedException exception) {
        logger.error("{}：{}", RespInfo.F405.msg, exception.getMessage());
        return ICarResult.build(RespInfo.F405);
    }

    /**
     * 未知异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public ICarResult exceptionHandler(Exception exception) {
        logger.error("全局异常：{}", exception.getMessage());
        return ICarResult.build(RespInfo.FAIL);
    }
}
