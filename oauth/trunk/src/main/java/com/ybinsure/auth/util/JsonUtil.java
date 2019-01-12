package com.ybinsure.auth.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ybinsure.auth.exception.FailResultException;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Optional;

/**
 * json工具类
 * created by eric on 18-2-5
 */
public class JsonUtil {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 将对象转换成json字符串,不格式化输出
     */
    public static Optional<String> toJson(Object data) {
        return toJsonOperator(data, false);
    }

    /**
     * 将对象转换成json字符串,格式化输出
     */
    public static Optional<String> toJsonWithFormat(Object data) {
        return toJsonOperator(data, true);
    }

    /**
     * Object转换成json
     *
     * @param data   转换的实例
     * @param format 是否格式化
     * @return 转换结果
     */
    private static Optional<String> toJsonOperator(Object data, boolean format) {
        if (data == null) {
            return Optional.empty();
        }
        try {
            MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            if (format) {
                return Optional.ofNullable(MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(data));
            }
            return Optional.ofNullable(MAPPER.writeValueAsString(data));
        } catch (JsonProcessingException e) {
            throw FailResultException.convertJsonError();
        }
    }

    /**
     * 将json结果集转化为对象
     */
    public static <T> Optional<T> toPojo(String jsonData, Class<T> beanType) {
        if (StringUtils.isBlank(jsonData)) {
            return Optional.empty();
        }
        try {
            return Optional.ofNullable(MAPPER.readValue(jsonData, beanType));
        } catch (Exception e) {
            throw FailResultException.convertJsonError();
        }
    }

    /**
     * 将json数据转换成pojo对象list
     */
    public static <T> Optional<List<T>> toList(String jsonData, Class<T> beanType) {
        if (StringUtils.isBlank(jsonData)) {
            return Optional.empty();
        }
        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        try {
            return Optional.ofNullable(MAPPER.readValue(jsonData, javaType));
        } catch (Exception e) {
            throw FailResultException.convertJsonError();
        }
    }
}
