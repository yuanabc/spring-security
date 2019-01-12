package com.ybinsure.auth.service.tool;

import com.ybinsure.auth.model.data.UserDO;
import com.ybinsure.auth.model.transfer.datong.UserLoginDTO;

import java.util.Optional;

/**
 * rsa方式登陆
 */
public interface DatongRsaLoginService {

    /**
     * 解析源请求报文
     * @param sourceMes 请求报文
     * @return 大童用户信息加密密文
     */
    Optional<String> cryptChar(String sourceMes);

    /**
     * 转换大童用户信息加密密文
     * @param crypt 加密密文
     * @return 大童用户信息实例
     */
    Optional<UserLoginDTO> decrypt(String crypt);

    /**
     * 转换成应用用户信息
     * @param param 大童用户信息
     * @return 应用用户信息
     */
    Optional<UserDO> convertUser(UserLoginDTO param);

}
