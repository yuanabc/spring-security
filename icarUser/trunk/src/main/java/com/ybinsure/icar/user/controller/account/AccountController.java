package com.ybinsure.icar.user.controller.account;

import com.ybinsure.icar.user.annotation.ControllerLog;
import com.ybinsure.icar.user.auth.AuthConst;
import com.ybinsure.icar.user.constant.ApiPath;
import com.ybinsure.icar.user.model.AuthInfo;
import com.ybinsure.icar.user.model.ICarResult;
import com.ybinsure.icar.user.model.PageInfo;
import com.ybinsure.icar.user.model.param.BonusParam;
import com.ybinsure.icar.user.model.vo.AccountVO;
import com.ybinsure.icar.user.model.vo.PerformanceVO;
import com.ybinsure.icar.user.service.func.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户服务接口
 * 注册/登录/找回密码/我的业绩
 *
 * @author HANHT
 * @version 2018/6/13 11:09
 */
@RestController
public class AccountController {

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 登录成功，查询账户信息
     *
     * @param param 查询参数
     * @return 账户信息
     */
    @ControllerLog(description = "查询账户信息")
    @PostMapping(ApiPath.ACCOUNT)
    public ICarResult<AccountVO> account(@Validated AuthInfo param, @RequestHeader(name = AuthConst.AUTH) String token) {
        // 赋值token
        param.setToken(token);

        return accountService.queryAccount(param).map(ICarResult::ok).orElseGet(ICarResult::fail);
    }

    /**
     * 查询用户业绩
     */
    @ControllerLog(description = "查询用户业绩")
    @PostMapping(ApiPath.ACCOUNT_PERFORMANCE)
    public ICarResult<PerformanceVO> performance(@Validated AuthInfo param) {

        return ICarResult.ok(accountService.queryPerformance(param).orElseGet(PerformanceVO::new));
    }

    @ControllerLog(description = "森锐账户信息查询")
    @PostMapping(ApiPath.SR_ACCOUNT)
    public ICarResult<PerformanceVO> queryAccount(@Validated AuthInfo param) {

        return ICarResult.ok(accountService.queryAccountInfo(param).orElseGet(PerformanceVO::new));
    }

    @ControllerLog(description = "森锐账户奖金列表")
    @PostMapping(ApiPath.SR_ACCOUNT_BONUS)
    public ICarResult listBonus(@Validated BonusParam param) {

        return ICarResult.ok(accountService.listBonus(param).orElseGet(PageInfo::new));
    }
}
