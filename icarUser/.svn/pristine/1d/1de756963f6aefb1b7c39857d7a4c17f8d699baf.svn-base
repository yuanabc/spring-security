package com.ybinsure.icar.user.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * jackson工具类
 *
 * @author HANHT
 * @version 2018/7/11 16:22
 */
public final class JsonUtil {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    /** 定义jackson对象 */
    private static final ObjectMapper MAPPER = new ObjectMapper();

    static {
        // 允许解析使用Java/C++ 样式的注释（包括'/'+'*' 和'//' 变量）
        MAPPER.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        // 允许使用非双引号属性名字
        MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        // 允许单引号来包住属性名称和字符串值
        MAPPER.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        // 允许包含特殊字符
        MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        // 过滤多余字段
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 不使用科学记数法
        MAPPER.configure(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN, true);
        // 过滤null
        MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    /**
     * 读取json串
     *
     * @param jsonData json串
     * @return JsonNode
     */
    public static Optional<JsonNode> readJson(String jsonData) {
        if (StrUtil.isBlank(jsonData)) {

            return Optional.empty();
        }

        try {
            return Optional.ofNullable(MAPPER.readTree(jsonData));
        } catch (IOException e) {
            logger.error("JsonUtil readJson exception : {}", e.getMessage());
        }
        return Optional.empty();
    }

    /**
     * 将对象转换成json字符串。
     *
     * @param data 对象
     * @return json串
     */
    public static Optional<String> toJson(Object data) {
        if (data == null) {

            return Optional.empty();
        }

        try {
            return Optional.ofNullable(MAPPER.writeValueAsString(data));
        } catch (JsonProcessingException e) {
            logger.error("JsonUtil toJson exception : {}", e.getMessage());
        }
        return Optional.empty();
    }

    /**
     * 将json结果集转化为对象
     *
     * @param jsonData json数据
     * @param beanType 对象中的object类型
     */
    public static <T> Optional<T> toPojo(String jsonData, Class<T> beanType) {
        if (StrUtil.isBlank(jsonData)) {

            return Optional.empty();
        }

        try {
            return Optional.ofNullable(MAPPER.readValue(jsonData, beanType));
        } catch (Exception e) {
            logger.error("JsonUtil toPojo exception : {}", e.getMessage());
        }
        return Optional.empty();
    }

    /**
     * 将json数据转换成pojo对象list
     *
     * @param jsonData json数据
     * @param beanType 转换对象
     * @param <T>      转换对象
     * @return list
     */
    public static <T> Optional<List<T>> toList(String jsonData, Class<T> beanType) {
        if (StrUtil.isBlank(jsonData)) {

            return Optional.empty();
        }

        JavaType javaType = MAPPER.getTypeFactory().constructParametricType(List.class, beanType);
        try {
            return Optional.ofNullable(MAPPER.readValue(jsonData, javaType));
        } catch (Exception e) {
            logger.error("JsonUtil toList exception : {}", e.getMessage());
        }
        return Optional.empty();
    }
}
