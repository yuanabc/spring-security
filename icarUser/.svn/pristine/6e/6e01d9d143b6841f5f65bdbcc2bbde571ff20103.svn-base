package com.ybinsure.icar.user.service.func;

import com.ybinsure.icar.user.model.AuthInfo;
import com.ybinsure.icar.user.model.PageInfo;
import com.ybinsure.icar.user.model.dto.AuthUserDTO;
import com.ybinsure.icar.user.model.param.BonusParam;
import com.ybinsure.icar.user.model.vo.AccountVO;
import com.ybinsure.icar.user.model.vo.BonusVO;
import com.ybinsure.icar.user.model.vo.PerformanceVO;

import java.util.Optional;

/**
 * 用户服务
 *
 * @author HANHT
 * @version 2018/7/7 11:40
 */
public interface AccountService {

    /**
     * 查询账户信息
     *
     * @param param 用户信息
     * @return 账户信息
     */
    Optional<AccountVO> queryAccount(AuthInfo param);

    /**
     * 查询用户业绩
     *
     * @param param 用户信息
     * @return 业绩封装对象
     */
    Optional<PerformanceVO> queryPerformance(AuthInfo param);

    /**
     * 查询森锐账户信息
     *
     * @param param 用户id
     * @return 账户信息
     */
    Optional<PerformanceVO> queryAccountInfo(AuthInfo param);

    /**
     * 查询奖金列表
     *
     * @param param 查询入参
     * @return 奖金列表
     */
    Optional<PageInfo<BonusVO>> listBonus(BonusParam param);

    /**
     * 根据用户token查询用户信息
     *
     * @param token 令牌
     * @return 用户信息
     */
    Optional<AuthUserDTO> queryUserByToken(String token);
}
