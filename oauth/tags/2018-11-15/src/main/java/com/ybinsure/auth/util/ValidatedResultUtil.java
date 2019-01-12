package com.ybinsure.auth.util;

import com.ybinsure.auth.exception.FailResultException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.Optional;

/**
 * 参数校验结果工具类
 */
public class ValidatedResultUtil {

    /**
     * 检查field校验结果
     * 限定一次展示一个校验结果，多个校验结果不好展示
     *
     * @param bindingResult 校验结果
     */
    public static Optional<String> checkField(BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                return Optional.of(fieldError.getDefaultMessage());
            }
        }
        return Optional.empty();
    }

    public static void checkFieldThrow(BindingResult bindingResult) {
        checkField(bindingResult).ifPresent(mes -> {
            throw new FailResultException(mes);
        });
    }
}
