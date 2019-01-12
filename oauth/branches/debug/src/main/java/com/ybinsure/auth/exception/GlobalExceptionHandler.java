package com.ybinsure.auth.exception;

import com.ybinsure.auth.model.transfer.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局处理抛出的异常
 * Created by eric on 17-8-31
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    public Result checkException(Exception e) {
        if (e instanceof FailResultException) {
            return failResultExceptionHandler((FailResultException) e);
        } else if (e instanceof ReturnResultException) {
            return returnResultExceptionHandler((ReturnResultException) e);
        } else {
            return exceptionHandler(e);
        }
    }

    /**
     * 异常结果，需要中断流程
     */
    @ExceptionHandler(FailResultException.class)
    @ResponseStatus(HttpStatus.OK)
    public Result failResultExceptionHandler(FailResultException exception) {
        return Result.error(exception.getMessage());
    }

    /**
     * 中断流程，返回结果到前端
     */
    @ExceptionHandler(ReturnResultException.class)
    @ResponseStatus(HttpStatus.OK)
    public Result returnResultExceptionHandler(ReturnResultException exception) {
        return exception.getResult();
    }

    /**
     * 权限异常
     *
     * @param accessDeniedException 捕获实例
     * @return 处理结果
     */
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.OK)
    public Result accessDeniedExceptionHandler(AccessDeniedException accessDeniedException) {
        return Result.authError();
    }

    /**
     * 捕获全局异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public Result exceptionHandler(Exception e) {
        logger.info("全局异常:{}", e);
        return Result.error();
    }

}
