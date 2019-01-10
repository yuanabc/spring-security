package com.ybinsure.icar.user.util;

import com.ybinsure.icar.user.exception.SystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * bean转化工具类
 *
 * @author HANHT
 * @version 2018/5/7 17:58
 */
public class BeanUtil {

    private static final Logger logger = LoggerFactory.getLogger(BeanUtil.class);

    /**
     * obj -> map
     */
    public static Map<String, Object> simpleObj2Map(Object obj) {
        if (obj == null) {
            return null;
        }

        // 查找所有属性（包括父类）
        Field[] declaredFields = getAllDeclaredFields(obj.getClass());
        // 判断空
        if (declaredFields == null || declaredFields.length == 0) {
            return null;
        }

        // 返回结果
        Map<String, Object> map = new HashMap<>(16);

        // 属性值
        Object value;
        for (Field field : declaredFields) {
            int mod = field.getModifiers();
            // 过滤静态/常量
            if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                continue;
            }

            field.setAccessible(true);
            try {
                value = field.get(obj);
            } catch (IllegalAccessException e) {
                logger.error("BeanUtil.obj2Map field.get exception: {}", e.getMessage());
                throw SystemException.exception();
            }

            // 跳过空值属性
            if (StrUtil.isNull(value)) {
                continue;
            }

            map.put(field.getName(), value);
        }

        return map;
    }

    /**
     * 获取所有属性（包括父类）
     */
    private static Field[] getAllDeclaredFields(Class<?> clazz) {
        if (clazz != Object.class) {

            return clazz.getDeclaredFields();
        }

        return null;
    }
}
