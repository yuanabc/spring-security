package com.ybinsure.auth.help;

import java.lang.reflect.Method;
import java.util.Optional;

/**
 * 方法工具类
 */
public class MethodUtils {

    /**
     * 获取指定的方法,包含public和private
     * @param t 需要反射的类型
     * @param methodName 方法名
     * @param params 反射方法的参数名
     * @return 匹配的方法
     */
    public static Optional<Method> getMethod(Class t, String methodName, Class... params) {
        Method[] methods = t.getDeclaredMethods();
        for (Method item : methods) {
            item.setAccessible(true);
            if (item.getName().equals(methodName) && matchParamTypes(item, params)) {
                return Optional.ofNullable(item);
            }
        }
        return Optional.empty();
    }

    /**
     * 匹配参数签名是否符合方法
     * @param method 需要匹配的方法
     * @param params 匹配的参数签名
     * @return 匹配结果
     */
    private static boolean matchParamTypes(Method method, Class... params) {
        Class[] methodParams = method.getParameterTypes();
        for (Class methodParam : methodParams) {
            for (Class param : params) {
                if (!methodParam.getName().equals(param.getName())) {
                    return false;
                }
            }
        }
        return true;
    }
}
