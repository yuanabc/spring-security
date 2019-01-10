package com.ybinsure.icar.user.wallet.service.impl;

import com.ybinsure.icar.user.mapper.wallet.WalletMapper;
import com.ybinsure.icar.user.wallet.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 钱包的
 *
 * @author lic
 */

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletMapper mapper;

    @Override
    public Map<String, Object> getWalletById(String uId) {
        // TODO Auto-generated method stub
        return mapper.getWalletById(uId);
    }

    @Override
    public boolean updateWalletPassword(String code, String uId, String pwd) {
        // TODO Auto-generated method stub
        int flag = mapper.updateWalletPassword(code, uId, pwd);
        if (flag == 1) {
            mapper.clearPassWordErr(uId);
        }
        return flag <= 0 ? false : true;
    }

    @Override
    public boolean addWalletPassword(String uId, String pwd) {
        // TODO Auto-generated method stub
        int flag = mapper.addWalletPassword(uId, pwd);
        return flag <= 0 ? false : true;
    }

    @Override
    public List<Map<String, Object>> getWalletRecord(int page, int row, String uId, int type) {
        // TODO Auto-generated method stub
        return mapper.getWalletRecord(page, row, uId, type);
    }

    @Override
    public Map<String, Object> checkUserRealNameAuth(String uId) {
        // TODO Auto-generated method stub
        return mapper.checkUserRealNameAuth(uId);
    }

    @Override
    public boolean bindWithdrawAccount(String uId, String accountHolder, String cardType, String cardNumber, String bankDeposit, String bank) {
        // TODO Auto-generated method stub
        int flag = mapper.bindWithdrawAccount(uId, accountHolder, cardType, cardNumber, bankDeposit, bank);
        return flag <= 0 ? false : true;
    }

    @Override
    public boolean withdraw(String uId, double amount) {
        // TODO Auto-generated method stub
        int flag = mapper.withdraw(uId, amount);
        return flag <= 0 ? false : true;
    }

    @Override
    public Map<String, Object> checkUserSigned(String uId, String personalMobile) {
        // TODO Auto-generated method stub
        return mapper.checkUserSigned(uId, personalMobile);
    }

    @Override
    public int saveUserSignedInfo(Map<String, Object> map) {
        return mapper.saveUserSignedInfo(map);
    }

    @Override
    public int updateSignedState(Map<String, Object> map) {
        // TODO Auto-generated method stub
        return mapper.updateSignedState(map);
    }

    @Override
    public int savePayInfo(Map<String, Object> map) {
        // TODO Auto-generated method stub
        return mapper.savePayInfo(map);
    }

    @Override
    public int updatePayInfo(Map<String, Object> map) {
        // TODO Auto-generated method stub
        return mapper.updatePayInfo(map);
    }

    @Override
    public Map<String, Object> getUserSignedById(String signOrderNo) {
        // TODO Auto-generated method stub
        return mapper.getUserSignedById(signOrderNo);
    }

    @Override
    public Map<String, Object> getUserInfoById(String uId) {
        // TODO Auto-generated method stub
        return mapper.getUserInfoById(uId);
    }
}
