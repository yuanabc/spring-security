package cn.merryyou.logback.validate.code.impl;

import cn.merryyou.logback.utils.JsonUtil;
import cn.merryyou.logback.utils.RedisUtils;
import cn.merryyou.logback.validate.code.ValidateCode;
import cn.merryyou.logback.validate.code.ValidateCodeException;
import cn.merryyou.logback.validate.code.ValidateCodeRepository;
import cn.merryyou.logback.validate.code.ValidateCodeType;

import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import com.google.gson.Gson;

/**
 * Created on 2018/1/10.
 *
 * @author zlf
 * @since 1.0
 */
@Component
public class RedisValidateCodeRepository implements ValidateCodeRepository {

    /**
     * 验证码放入Redis时的前缀
     */
    String REDIS_KEY_PREFIX = "REDIS_KEY_FOR_CODE:";

    @Autowired
    private RedisUtils redisUtils ;

    @Override
    public void save(ServletWebRequest request, ValidateCode code, ValidateCodeType validateCodeType) {
    	redisUtils.setExpire(getSessionKey(request, validateCodeType), JsonUtil.toJson(code), code.getExpireTime().toEpochSecond(ZoneOffset.of("+8")));
    }

    @Override
    public ValidateCode get(ServletWebRequest request, ValidateCodeType validateCodeType) {
    	String key = getSessionKey(request, validateCodeType);
        String json = redisUtils.get(key);
        if(json == null) {
        	return null;
        }
        //反序列化
        Gson gson=new Gson();
        return gson.fromJson(json, ValidateCode.class);
    }

    @Override
    public void remove(ServletWebRequest request, ValidateCodeType codeType) {
        redisUtils.del(getSessionKey(request, codeType));
    }

    /**
     * 构建验证码翻入session得可以
     *
     * @return
     */
    private String getSessionKey(ServletWebRequest request, ValidateCodeType validateCodeType) {
    	String deviceId = request.getHeader("deviceId");
    	if(deviceId == null) {
    		throw new ValidateCodeException("请在请求头中携带deviceId参数");
    	}
        return REDIS_KEY_PREFIX + validateCodeType.toString().toLowerCase()+":"+deviceId;
    }
}
