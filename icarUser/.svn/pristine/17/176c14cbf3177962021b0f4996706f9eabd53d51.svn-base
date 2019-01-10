package com.ybinsure.icar.user.util;

import com.ybinsure.icar.user.auth.AuthConst;
import com.ybinsure.icar.user.constant.ConfigConst;
import com.ybinsure.icar.user.exception.AuthenticationException;
import com.ybinsure.icar.user.exception.FailResultException;
import okhttp3.*;
import okhttp3.FormBody.Builder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

/**
 * OkHttp3请求服务
 *
 * @author HANHT
 * @version 2017/12/13 14:11
 */
public final class HttpUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    private static final MediaType XML_CONTENT_TYPE = MediaType.parse("application/xml; charset=utf-8");
    private static final MediaType MEDIA_TYPE_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");
    private static final MediaType JSON_CONTENT_TYPE = MediaType.parse("application/json; charset=utf-8");
    private static final MediaType FORM_CONTENT_TYPE = MediaType.parse("application/x-www-form-urlencoded; charset=utf-8");
    public static OkHttpClient OKHTTP;

    /**
     * 初始化OkHttpClient
     */
    private static synchronized void initHTTP() {
        // 多线程同步锁 判断空 解决单例问题
        if (OKHTTP != null) {
            return;
        }

        System.out.println("初始化OKHTTP。。。");
        OKHTTP = new OkHttpClient.Builder()
                // 设置连接超时
                .connectTimeout(ConfigConst.CONNECT_TIMEOUT, TimeUnit.MINUTES)
                // 设置写超时
                .writeTimeout(ConfigConst.WRITE_TIMEOUT, TimeUnit.MINUTES)
                // 设置读超时
                .readTimeout(ConfigConst.READ_TIMEOUT, TimeUnit.MINUTES).build();
    }

    /**
     * 获取OkHttpClient
     */
    private static OkHttpClient getHTTP() {
        if (OKHTTP == null) {
            initHTTP();
        }

        return OKHTTP;
    }

    /**
     * http post json请求
     */
    public static String postJson(String url, String json) {

        return post(url, json, JSON_CONTENT_TYPE);
    }

    /**
     * http post xml请求
     */
    public static String postXml(String url, String xml) {

        return post(url, xml, XML_CONTENT_TYPE);
    }

    /**
     * http post form 请求
     */
    public static String postForm(String url, String param) {

        return post(url, param, FORM_CONTENT_TYPE);
    }

    /**
     * http doGet 请求
     * 自己拼接参数&
     */
    public static String doGet(String url) {

        return doGetWithToken(url, "");
    }

    /**
     * get 带token请求
     *
     * @param url   请求地址
     * @param token 认证
     * @return 结果
     */
    public static String doGetWithToken(String url, String token) {
        try {
            Request.Builder builder = new Request.Builder().url(url);
            if (StrUtil.isNotBlank(token)) {
                builder.addHeader(AuthConst.AUTH, token);
            }

            Request request = builder.get().build();
            Response response = getHTTP().newCall(request).execute();

            // 请求不成功
            if (!response.isSuccessful()) {
                throw AuthenticationException.failure();
            }

            ResponseBody body = response.body();
            if (body == null) {
                throw FailResultException.connectionException();
            }

            return body.string();
        } catch (IOException e) {
            throw FailResultException.connectionException();
        }
    }

    /**
     * http post json请求
     */
    public static String post(String url, String params, MediaType type) {
        try {
            RequestBody requestBody = RequestBody.create(type, params);
            Request request = new Request.Builder().url(url).post(requestBody).build();
            Response response = getHTTP().newCall(request).execute();
            ResponseBody body = response.body();
            if (body == null) {
                throw FailResultException.connectionException();
            }
            return body.string();
        } catch (IOException e) {
            throw FailResultException.connectionException();
        }
    }

    /**
     * http post form请求
     */
    public static String postForm(String url, Map<String, ?> params) {

        return postFormWithToken(url, params, "");
    }

    /**
     * http post form with token请求
     */
    public static String postFormWithToken(String url, Map<String, ?> params, String token) {
        try {
            Builder builder = new FormBody.Builder();
            for (Entry<String, ?> entry : params.entrySet()) {
                builder.add(entry.getKey(), String.valueOf(entry.getValue()));
            }
            FormBody formBody = builder.build();

            Request.Builder requestBuilder = new Request.Builder().url(url);
            if (StrUtil.isNotBlank(token)) {
                requestBuilder.addHeader(AuthConst.AUTH, token);
            }

            Request request = requestBuilder.post(formBody).build();
            Response response = getHTTP().newCall(request).execute();
            // 请求不成功
            if (!response.isSuccessful()) {
                throw AuthenticationException.failure();
            }

            ResponseBody body = response.body();
            if (body == null) {
                throw FailResultException.connectionException();
            }

            return body.string();
        } catch (IOException e) {
            throw FailResultException.connectionException();
        }
    }

    /**
     * 上传文件
     *
     * @param url    请求地址
     * @param file   文件对象
     * @param params 附加参数
     */
    public static void uploadFile(String url, File file, Map<String, ?> params) {
        try {
            MultipartBody.Builder multipartBody = new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("file", file.getName(), RequestBody.create(MediaType.parse("image/*"), file));
            // 遍历添加入参
            for (Entry<String, ?> entry : params.entrySet()) {
                multipartBody.addFormDataPart(entry.getKey(), String.valueOf(entry.getValue()));
            }

            Request request = new Request.Builder().url(url).post(multipartBody.build()).build();

            getHTTP().newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    logger.error("uploadFile failure : {}", e.getMessage());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String msg;
                    ResponseBody body = response.body();
                    if (body == null) {
                        msg = Integer.toString(response.code());
                    } else {
                        msg = body.string();
                    }
                    logger.info("uploadFile response = {}", msg);
                }
            });
        } catch (Exception e) {
            throw FailResultException.connectionException();
        }
    }

    public static String postStream(String url, InputStream stream) {
        try {
            RequestBody requestBody = RequestBody.create(MEDIA_TYPE_MARKDOWN, getBytes(stream));
            Request request = new Request.Builder().url(url).post(requestBody).build();
            Response response = getHTTP().newCall(request).execute();
            ResponseBody body = response.body();
            if (body == null) {
                throw FailResultException.connectionException();
            }
            return body.string();
        } catch (Exception e) {
            throw FailResultException.connectionException();
        }
    }

    private static byte[] getBytes(InputStream in) throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }
        in.close();
        out.close();
        return out.toByteArray();
    }
}
