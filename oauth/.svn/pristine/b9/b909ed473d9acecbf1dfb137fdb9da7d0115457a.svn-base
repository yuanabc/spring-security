package com.ybinsure.auth.serviceImpl.tool;

import com.ybinsure.auth.exception.FailResultException;
import com.ybinsure.auth.service.tool.HttpService;
import com.ybinsure.auth.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import okhttp3.*;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class DefaultHttpService implements HttpService {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(DefaultHttpService.class);

    private static final OkHttpClient httpClient =
            new OkHttpClient().newBuilder()
                    .readTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .connectTimeout(30, TimeUnit.SECONDS).build();
    private static final MediaType XML_CONTENT_TYPE
            = MediaType.parse("text/xml; charset=utf-8");
    private static final MediaType JSON_CONTENT_TYPE
            = MediaType.parse("application/json;charset=utf-8");

    /**
     * 发起http post请求
     */
    @Override
    public <T> Optional<T> postJson(String url, Object data, Class<T> tClass) {
        try {
            String param = JsonUtil.toJson(data).orElse("");
            RequestBody requestBody = RequestBody.create(JSON_CONTENT_TYPE, param);
            Request request = new Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .build();
            Response response = httpClient.newCall(request).execute();
            String responseBody = response.body().string();
            logger.info("---http postJson start---");
            logger.info("param---{}", JsonUtil.toJson(data));
            logger.info("response---{}", responseBody);
            return JsonUtil.toPojo(responseBody, tClass);
        } catch (IOException e) {
            throw FailResultException.connectError();
        }
    }

    @Override
    public <T> Optional<T> postEncode(String url, Map<String, String> data, Class<T> tClass) {
        try {
            Request request = new Request.Builder()
                    .url(url)
                    .post(enCodeRequestBody(data))
                    .build();
            Response response = httpClient.newCall(request).execute();
            String responseBody = response.body().string();
            logger.info("---http postEncode start---");
            logger.info("param---{}", data);
            logger.info("response---{}", responseBody);
            return JsonUtil.toPojo(responseBody, tClass);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    private  RequestBody enCodeRequestBody(Map<String, String> data) {
        FormBody.Builder builder = new FormBody.Builder();
        for (String key : data.keySet()) {
            builder.add(key, data.get(key));
        }
        return builder.build();
    }


}
