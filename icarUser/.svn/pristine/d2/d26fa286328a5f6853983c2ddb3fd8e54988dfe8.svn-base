package com.ybinsure.icar.user.wallet;

import com.fasterxml.jackson.databind.JsonNode;
import com.ybinsure.icar.user.annotation.ControllerLog;
import com.ybinsure.icar.user.exception.AuthenticationException;
import com.ybinsure.icar.user.exception.FailResultException;
import com.ybinsure.icar.user.util.JsonUtil;
import com.ybinsure.icar.user.util.StrUtil;
import com.ybinsure.icar.user.auth.AuthenticationHelper;
import com.ybinsure.icar.user.wallet.dto.Certification;
import com.ybinsure.icar.user.wallet.service.WalletService;
import com.ybinsure.icar.user.wallet.util.AygUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lichuan
 * 2018-03-20
 */

@RestController
@RequestMapping("/v1/auth/wallet")
public class WalletController {

    //   private static final Logger logger = LoggerFactory.getLogger(WalletController.class);

    @Resource
    private WalletService service;

    @Value("${ayg_url:}")
    private String ayg_url;

    @ControllerLog(description = "返回钱包")
    @RequestMapping("/jGetWalletById")
    public Object jGetWalletById(HttpServletRequest request) throws Exception {
        Map<String, Object> respoMap = new HashMap<String, Object>();
        String uId = AuthenticationHelper.getId().orElseThrow(AuthenticationException::unauthorized);
        Map<String, Object> data = service.getWalletById(uId);
        respoMap.put("r", data);
        return respoMap;
    }

    @ControllerLog(description = "检测用户是否被实名认证")
    @RequestMapping("/jCheckUserRealNameAuth")
    public Object jCheckUserRealNameAuth(HttpServletRequest request) throws Exception {
        Map<String, Object> respoMap = new HashMap<String, Object>();
        String uId = AuthenticationHelper.getId().orElseThrow(AuthenticationException::unauthorized);
        Map<String, Object> data = service.checkUserRealNameAuth(uId);
        respoMap.put("r", data);
        return respoMap;
    }

    @ControllerLog(description = "设置提现密码")
    @RequestMapping("/jAddWalletPassword")
    public Object jAddWalletPassword(HttpServletRequest request) throws Exception {
        Map<String, Object> respoMap = new HashMap<String, Object>();
        String uId = AuthenticationHelper.getId().orElseThrow(AuthenticationException::unauthorized);
        String pwd = (String) request.getParameter("pwd");
        boolean flag = service.addWalletPassword(uId, pwd);
        if (!flag) {
            respoMap.put("e", "已设提现密码");
        }
        respoMap.put("r", flag);
        return respoMap;
    }

    @ControllerLog(description = "修改，绑定开户账号")
    @RequestMapping("/jBindWithdrawAccount")
    public Object jBindWithdrawAccount(HttpServletRequest request) throws Exception {
        Map<String, Object> respoMap = new HashMap<String, Object>();
        String uId = AuthenticationHelper.getId().orElseThrow(AuthenticationException::unauthorized);
        String accountHolder = request.getParameter("accountHolder");
        String cardType = request.getParameter("cardType");
        String cardNumber = request.getParameter("cardNumber");
        String bankDeposit = request.getParameter("bankDeposit");
        String bank = request.getParameter("bank");
        if (cardType == null || cardNumber == null) {
            respoMap.put("e", "必要参数不能为空");
            return respoMap;
        }
        Map<String, Object> user = service.getUserInfoById(uId);
        String result = certification(Integer.parseInt(cardType), user.get("named") + "", user.get("idNo") + "", cardNumber, user.get("cell") + "");
        JsonNode json = JsonUtil.readJson(result).orElseThrow(FailResultException::dataException);
        if ("0000".equals(json.path("code").asText())) {
            //隔两秒主动去查询
            Thread.sleep(2500);
            result = getCertificationInfo(json.path("data").path("requestId").asText());
            json = JsonUtil.readJson(result).orElseThrow(FailResultException::dataException);
            if ("0000".equals(json.path("code").asText())) {
                String tempFlag = json.path("data").path("certResult").asText();
                //审核通过
                if ("1".equals(tempFlag)) {
                    boolean flag = service.bindWithdrawAccount(uId, accountHolder, cardType, cardNumber, bankDeposit, bank);
                    respoMap.put("r", flag);
                    return respoMap;
                }
                //0为审核中，再一次主动去查结果，
                else if ("0".equals(tempFlag)) {
                    Thread.sleep(1500);
                    result = getCertificationInfo(json.path("data").path("requestId").asText());
                    json = JsonUtil.readJson(result).orElseThrow(FailResultException::dataException);
                    tempFlag = json.path("data").path("certResult").asText();
                    if ("1".equals(tempFlag)) {
                        boolean flag = service.bindWithdrawAccount(uId, accountHolder, cardType, cardNumber, bankDeposit, bank);
                        respoMap.put("r", flag);
                        return respoMap;
                    } else {
                        respoMap.put("e", "绑卡失败,只能绑定当前持卡人的银行卡");
                        return respoMap;
                    }
                } else {
                    respoMap.put("e", "绑卡失败,只能绑定当前持卡人的银行卡");
                    return respoMap;
                }
            } else {
                respoMap.put("e", "获取效验结果异常");
                return respoMap;
            }
        } else {
            respoMap.put("e", "效验异常");
            return respoMap;
        }
    }

    @ControllerLog(description = "修改提现的密码")
    @RequestMapping("/jUpdateWalletPassword")
    public Object jUpdateWalletPassword(HttpServletRequest request) throws Exception {
        Map<String, Object> respoMap = new HashMap<String, Object>();
        String uId = AuthenticationHelper.getId().orElseThrow(AuthenticationException::unauthorized);
        String pwd = request.getParameter("pwd");
        String code = request.getParameter("code");
        if (StrUtil.isBlank(code) || StrUtil.isBlank(pwd)) {
            respoMap.put("e", "必要参数不能为空");
            return respoMap;
        }
        boolean flag = service.updateWalletPassword(code, uId, pwd);
        respoMap.put("r", flag);
        return respoMap;
    }

    @ControllerLog(description = "提现申请")
    @RequestMapping("/jWithdraw")
    public Object jWithdraw(HttpServletRequest request) throws Exception {
        Map<String, Object> respoMap = new HashMap<String, Object>();
        String uId = AuthenticationHelper.getId().orElseThrow(AuthenticationException::unauthorized);
        String amount = (String) request.getParameter("amount");
        double amountV = StrUtil.toDouble(amount, -1);
        if (amountV == -1) {
            respoMap.put("e", "参数非法");
            return respoMap;
        }
        Map<String, Object> data = service.getWalletById(uId);
        double wallet = StrUtil.toDouble(data.get("wallet"), 0);
        if (wallet < amountV) {
            respoMap.put("e", "提现金额错误");
            return respoMap;
        }
        boolean flag = service.withdraw(uId, amountV);
        respoMap.put("r", flag);
        return respoMap;
    }

    @ControllerLog(description = "钱包明细的列表")
    @RequestMapping("/jGetWalletRecord")
    public Object jGetWalletRecord(HttpServletRequest request) throws Exception {
        Map<String, Object> respoMap = new HashMap<String, Object>();
        String uId = AuthenticationHelper.getId().orElseThrow(AuthenticationException::unauthorized);
        int page = StrUtil.toInt(request.getParameter("page"), 0);
        int row = StrUtil.toInt(request.getParameter("row"), 10);
        int type = StrUtil.toInt(request.getParameter("type"), 0);
        page = page * row;
        List<Map<String, Object>> data = service.getWalletRecord(page, row, uId, type);
        respoMap.put("r", data);
        return respoMap;
    }

    /***
     *  绑卡效验名字与卡
     * @param type 0为银行卡，1为支付宝
     * @param cardId 身份证
     * @param payAccount 账号
     * @param cell 手机号
     * @return
     */
    private String certification(int type, String named, String cardId, String payAccount, String cell) {
        String appId = AygUtils.AYG_EXTRSYSTEM_ID;
        //String url = "https://hmjsjopenapi.aiyuangong.net/prepare";
        String method = "/prepare/asyn/certification";
        String nonce = AygUtils.randomUUID();
        String timestamp = System.currentTimeMillis() + "";
        //公共请求参数
        Certification reqParam = new Certification();
        reqParam.setExtrSystemId(appId);
        reqParam.setNonce(nonce);
        reqParam.setTimestamp(timestamp);
        reqParam.setRequestId(nonce);
        //附加请求参数
        reqParam.setName(named);
        reqParam.setIdcard(cardId);
        reqParam.setMobile(cell);
        reqParam.setValidType("3");//三要素认证（姓名+身份证+银行卡）
        if (type == 1) {
            reqParam.setPayAccountType("ALIPAY_LOGONID");
        } else if (type == 0) {
            reqParam.setPayAccountType("BANK_CARDNO");
        }
        reqParam.setPayAccount(payAccount);
        //生成签名
        String sign = AygUtils.digest(reqParam, AygUtils.YB_PRIVATE_KEY);
        reqParam.setSign(sign);
        reqParam.setSignType("RSA");
        String resultJson = AygUtils.sendPostStr(ayg_url + method, JsonUtil.toJson(reqParam).orElse(""));
        System.out.println("爱员工：" + resultJson);
        return resultJson;
    }

    /***
     *  主动查询绑卡效验的结果
     * @return
     */
    private String getCertificationInfo(String cerRequestId) {
        String appId = AygUtils.AYG_EXTRSYSTEM_ID;
        //String url = "https://hmjsjopenapi.aiyuangong.net/prepare";
        String method = "/prepare/certification/result";
        String nonce = AygUtils.randomUUID();
        String timestamp = System.currentTimeMillis() + "";
        //公共请求参数
        Certification reqParam = new Certification();
        reqParam.setExtrSystemId(appId);
        reqParam.setNonce(nonce);
        reqParam.setTimestamp(timestamp);
        reqParam.setRequestId(nonce);
        //附加请求参数
        reqParam.setCerRequestId(cerRequestId);

        //生成签名
        String sign = AygUtils.digest(reqParam, AygUtils.YB_PRIVATE_KEY);
        reqParam.setSign(sign);
        reqParam.setSignType("RSA");
        String resultJson = AygUtils.sendPostStr(ayg_url + method, JsonUtil.toJson(reqParam).orElse(""));
        System.out.println("爱员工主动查询效验卡的结果：" + resultJson);
        return resultJson;
    }

}
