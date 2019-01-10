package com.ybinsure.icar.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.ybinsure.icar.user.constant.SwitchCode;
import com.ybinsure.icar.user.mapper.extend.AddressExtendMapper;
import com.ybinsure.icar.user.model.PageInfo;
import com.ybinsure.icar.user.model.data.AddressDO;
import com.ybinsure.icar.user.model.data.AddressDOExample;
import com.ybinsure.icar.user.model.param.AddressParam;
import com.ybinsure.icar.user.model.vo.AddressVO;
import com.ybinsure.icar.user.service.data.AddressService;
import com.ybinsure.icar.user.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * 保单配送地址服务
 *
 * @author HANHT
 * @version 2018/7/7 17:06
 */
@Service
public class AddressServiceImpl implements AddressService {

    private final AddressExtendMapper addressExtendMapper;

    @Autowired
    public AddressServiceImpl(AddressExtendMapper addressExtendMapper) {
        this.addressExtendMapper = addressExtendMapper;
    }

    @Override
    public Optional<PageInfo<AddressVO>> queryAddressByUser(PageInfo param) {
        param.setOrderBy("id");
        param.setSortord(1);

        PageHelper.startPage(param.getPageNum(), param.getPageSize(), param.assembleSort());

        return Optional.of(PageInfo.instance(addressExtendMapper.selectAddressByUser(param.getAuth())));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addAddress(AddressParam param) {
        AddressDO addressDO = getAddressDO(param);

        if (addressExtendMapper.insertSelective(addressDO) <= 0) {

            return false;
        }

        // 设置默认地址，更新其他地址为非默认
        if (1 == param.getIsDefault()) {
            disableUserOtherAddress(param);
        }

        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateAddress(AddressParam param) {
        AddressDOExample example = new AddressDOExample();
        example.or().andIdEqualTo(param.getAddrId()).andUIdEqualTo(param.getAuth());

        if (addressExtendMapper.countByExample(example) == 0) {

            return false;
        }

        AddressDO addressDO = getAddressDO(param);
        // 更新
        if (addressExtendMapper.updateByExampleSelective(addressDO, example) <= 0) {

            return false;
        }

        // 设置默认地址，更新其他地址为非默认
        if (1 == param.getIsDefault()) {
            disableUserOtherAddress(param);
        }

        return true;
    }

    @Override
    public boolean deleteAddress(AddressParam param) {
        AddressDOExample example = new AddressDOExample();
        example.or().andIdEqualTo(param.getAddrId()).andUIdEqualTo(param.getAuth());

        return addressExtendMapper.countByExample(example) == 1 && addressExtendMapper.deleteByExample(example) > 0;
    }

    /**
     * 组装数据参数
     */
    private AddressDO getAddressDO(AddressParam param) {
        AddressDO addressDO = new AddressDO();
        addressDO.setName(param.getName());
        addressDO.setPhone(StrUtil.toLong(param.getPhone(), 0));
        addressDO.setAddress(param.getAddress());
        addressDO.setIsDefault(1 == param.getIsDefault() ? SwitchCode.ENABLE : SwitchCode.DISABLE);
        addressDO.setuId(param.getAuth());
        return addressDO;
    }

    /**
     * 禁用用户其他收件地址
     *
     * @param param 条件
     */
    private void disableUserOtherAddress(AddressParam param) {
        AddressDOExample example2 = new AddressDOExample();
        example2.or().andIdNotEqualTo(param.getAddrId()).andUIdEqualTo(param.getAuth());

        AddressDO addressDO = new AddressDO();
        addressDO.setIsDefault(SwitchCode.DISABLE);

        addressExtendMapper.updateByExampleSelective(addressDO, example2);
    }
}
