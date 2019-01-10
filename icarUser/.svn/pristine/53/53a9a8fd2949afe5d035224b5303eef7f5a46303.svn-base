package com.ybinsure.icar.user.service.impl;

import com.ybinsure.icar.user.constant.RiskInfo;
import com.ybinsure.icar.user.constant.SwitchCode;
import com.ybinsure.icar.user.mapper.data.PolicyRiskDOMapper;
import com.ybinsure.icar.user.model.data.PolicyRiskDO;
import com.ybinsure.icar.user.model.data.PolicyRiskDOExample;
import com.ybinsure.icar.user.model.vo.PolicyRiskVO;
import com.ybinsure.icar.user.service.data.PolicyRiskService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * 保单险种信息服务实现
 *
 * @author HANHT
 * @version 2018/7/9 11:18
 */
@Service
public class PolicyRiskServiceImpl implements PolicyRiskService {

    private final PolicyRiskDOMapper policyRiskDOMapper;

    @Autowired
    public PolicyRiskServiceImpl(PolicyRiskDOMapper policyRiskDOMapper) {
        this.policyRiskDOMapper = policyRiskDOMapper;
    }

    @Override
    public Optional<List<PolicyRiskVO>> queryRisks(String policyId) {
        PolicyRiskDOExample riskDOExample = new PolicyRiskDOExample();
        riskDOExample.or().andPolicyIdEqualTo(policyId);
        // 查询保单险种数据
        List<PolicyRiskDO> risks = policyRiskDOMapper.selectByExample(riskDOExample);
        if (risks == null || risks.isEmpty()) {

            return Optional.empty();
        }

        List<PolicyRiskVO> result = new ArrayList<>();
        // 遍历加入主险
        risks.forEach(o -> {
            // 赋值险别名称
            o.setRiskName(RiskInfo.matchName(o.getRiskCode()));
            PolicyRiskVO vo = new PolicyRiskVO();
            result.add(vo);
            BeanUtils.copyProperties(o, vo);
        });
        // 遍历加入不计免赔
        risks.stream().filter(o -> Objects.equals(o.getIsDeductible(), SwitchCode.ENABLE)).forEach(o -> {
            PolicyRiskVO vo = new PolicyRiskVO();
            result.add(vo);

            vo.setRiskName("不计免(" + o.getRiskName() + ")");
            vo.setPremium(o.getDeductPremium());
        });

        return Optional.of(result);
    }
}
