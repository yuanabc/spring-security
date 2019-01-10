package com.ybinsure.icar.user.service.func;

import com.fasterxml.jackson.databind.JsonNode;
import com.ybinsure.icar.user.exception.SystemException;
import com.ybinsure.icar.user.util.HttpUtil;
import com.ybinsure.icar.user.util.JsonUtil;
import com.ybinsure.icar.user.util.StrUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 获取微信jsapi_ticket ,为微信公众号服务的
 * http://blog.csdn.net/suochunlong/article/details/53032497
 *
 * @author lichuan
 * @version v2.0 Copyright (c) 2017,深圳市喏喏网络科技有限公司 All rights reserved.
 */
@Component
public class WechatService {

    private final String appid = "wx959f3fb5f81aab39";
    private final String secret = "91b5e77ea6b6f734460a3d8e9302e9f5";

    //車保通
    private final String appid_cbt = "wx0cde8312dd171b30";
    private final String secret_cbt = "b95d89d8f842d6e73369c54c413658d1";

    @Resource(name = "redisCacheService")
    private CacheService<String> redis;

    private static final Logger logger = LoggerFactory.getLogger(WechatService.class);

    /**
     * 取得签名信息
     */
    public Map<String, String> getInfo(String url) throws Exception {

        //车保通的分享签名
        if (url.contains("110")) {
            String jsapi_ticket = redis.getCacheObject("weixin_cbt");
            if (StrUtil.isBlank(jsapi_ticket)) {
                jsapi_ticket = getJsapiTicket_cbt();
            }
            return getSign_cbt(url, jsapi_ticket);

        }
        //悦保的分享签名
        else {
            String jsapi_ticket = redis.getCacheObject("weixin");
            if (StrUtil.isBlank(jsapi_ticket)) {
                jsapi_ticket = getJsapiTicket();
            }
            return getSign(url, jsapi_ticket);
        }
    }

    /**
     * 第一步获取 access_token ，第二步：用第一步拿到的access_token 采用http GET方式请求获得jsapi_ticket
     * （有效期7200秒，开发者必须在自己的服务全局缓存jsapi_ticket）
     */
    private String getJsapiTicket() throws Exception {
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/token?";
        String params = "grant_type=client_credential&appid=" + appid + "&secret=" + secret + "";
        String result = HttpUtil.doGet(requestUrl + params);
        logger.info("悦宝验签返回:{}", result);
        if (StrUtil.isBlank(result)) {
            return null;
        }

        JsonNode jn = JsonUtil.readJson(result).orElseThrow(SystemException::exception);

        String access_token = jn.path("access_token").asText();

        requestUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?";
        params = "access_token=" + access_token + "&type=jsapi";
        result = HttpUtil.doGet(requestUrl + params);
        logger.info("悦宝验签返回@@:{}", result);
        if (StrUtil.isBlank(result)) {
            return null;
        }

        jn = JsonUtil.readJson(result).orElseThrow(SystemException::exception);

        String jsapi_ticket = jn.path("ticket").asText();
        // int activeTime = jn.path("expires_in").asInt();

        // 必須有效時間
        redis.setCacheObject("weixin", jsapi_ticket, 7000, TimeUnit.SECONDS);

        return jsapi_ticket;
    }

    /**
     * 车保通的
     */
    private String getJsapiTicket_cbt() throws Exception {
        String requestUrl = "https://api.weixin.qq.com/cgi-bin/token?";
        String params = "grant_type=client_credential&appid=" + appid_cbt + "&secret=" + secret_cbt + "";
        String result = HttpUtil.doGet(requestUrl + params);

        if (StrUtil.isBlank(result)) {
            return null;
        }

        JsonNode jn = JsonUtil.readJson(result).orElseThrow(SystemException::exception);

        String access_token = jn.path("access_token").asText();

        requestUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?";
        params = "access_token=" + access_token + "&type=jsapi";
        result = HttpUtil.doGet(requestUrl + params);

        if (StrUtil.isBlank(result)) {
            return null;
        }

        jn = JsonUtil.readJson(result).orElseThrow(SystemException::exception);

        String jsapi_ticket = jn.path("ticket").asText();
        // int activeTime = jn.path("expires_in").asInt();

        // 必須有效時間
        redis.setCacheObject("weixin_cbt", jsapi_ticket, 7000, TimeUnit.SECONDS);
        logger.info("车保通生成的分享jsapi_ticket：" + jsapi_ticket);
        return jsapi_ticket;
    }

    /**
     * 签名
     */
    private Map<String, String> getSign(String url, String jsapi_ticket) {
        HashMap<String, String> map = new HashMap<>();
        String noncestr = getNonceStr();
        String timestamp = getTimeStamp();
        String sign = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + noncestr + "&timestamp=" + timestamp + "&url=" + url;
        logger.info("签名请求:{}", sign);
        sign = SHA1(sign);
        map.put("appid", appid);
        map.put("noncestr", noncestr);
        map.put("timestamp", timestamp);
        map.put("sign", sign);
        map.put("jsapi_ticket", jsapi_ticket);
        logger.info("签名返回:{}", map.toString());
        return map;
    }

    private Map<String, String> getSign_cbt(String url, String jsapi_ticket) {
        HashMap<String, String> map = new HashMap<>();
        String noncestr = getNonceStr();
        String timestamp = getTimeStamp();
        String sign = "jsapi_ticket=" + jsapi_ticket + "&noncestr=" + noncestr + "&timestamp=" + timestamp + "&url=" + url;
        sign = SHA1(sign);
        map.put("appid", appid_cbt);
        map.put("noncestr", noncestr);
        map.put("timestamp", timestamp);
        map.put("sign", sign);
        map.put("jsapi_ticket", jsapi_ticket);
        return map;
    }

    private String getNonceStr() {
        Random random = new Random();
        return DigestUtils.md5Hex(String.valueOf(random.nextInt(10000)).getBytes());
    }

    private String getTimeStamp() {
        return String.valueOf(System.currentTimeMillis() / 1000);

    }

    /**
     * 用SHA1算法生成安全签名
     *
     * @return 安全签名
     */
    private static String SHA1(String decript) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(decript.getBytes());
            byte[] messageDigest = digest.digest();
            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            // 字节数组转换为 十六进制 数
            String shaHex;
            for (byte b : messageDigest) {
                shaHex = Integer.toHexString(b & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        String url = "http://ybinsure.com/company/110/";
        if (url.contains("110")) {
            System.out.println("fdf");
        }
    }
}
