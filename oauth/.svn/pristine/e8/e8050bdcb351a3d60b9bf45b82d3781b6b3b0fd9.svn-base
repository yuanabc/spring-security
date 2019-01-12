package com.ybinsure.auth.util;

import com.ybinsure.auth.OauthApplicationTests;
import com.ybinsure.auth.mapper.data.CompanyDOMapper;
import com.ybinsure.auth.model.data.CompanyDO;
import com.ybinsure.auth.model.data.CompanyDOExample;
import com.ybinsure.auth.model.data.PolicyAreaDO;
import com.ybinsure.auth.service.data.PolicyAreaService;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CompanyConvertTest extends OauthApplicationTests {

    private static final Logger logger = LoggerFactory.getLogger(CompanyConvertTest.class);

    @Autowired(required = false)
    CompanyDOMapper companyDOMapper;

    @Autowired
    PolicyAreaService policyAreaService;

    @Test
    public void convertPolicyArea() {
        List<CompanyDO> companyDOS = Optional.ofNullable(companyDOMapper.selectByExample(new CompanyDOExample())).orElseGet(ArrayList::new);
        List<PolicyAreaDO> policyAreaDOS = policyAreaService.queryAll().orElseGet(ArrayList::new);
        companyDOS.forEach(companyDO -> {
            CompanyDO param = new CompanyDO();
            param.setId(companyDO.getId());
            Optional<String> cityPolicyAreaOptional = policyAreaDOS.stream()
                    .filter(policyAreaDO -> StringUtils.equals(policyAreaDO.getDistrictCode(), companyDO.getCity()))
                    .findAny()
                    .map(PolicyAreaDO::getAreaCode);
            Optional<String> provincePolicyAreaOptional = policyAreaDOS.stream()
                    .filter(policyAreaDO -> StringUtils.equals(policyAreaDO.getDistrictCode(), companyDO.getProvince()))
                    .findAny()
                    .map(PolicyAreaDO::getAreaCode);
            if (cityPolicyAreaOptional.isPresent()) {
                param.setAreaCode(cityPolicyAreaOptional.get());
                update(param);
                return;
            }

            provincePolicyAreaOptional.ifPresent(provincePolicyArea -> {
                param.setAreaCode(provincePolicyArea);
                update(param);
            });
        });
    }

    private void update(CompanyDO param) {
        logger.info("更新机构信息---{}", JsonUtil.toJson(param).orElse(""));
        if (companyDOMapper.updateByPrimaryKeySelective(param) < 1) {
            logger.info("更新机构信息失败---{}", JsonUtil.toJson(param).orElse(""));
        }
    }
}
