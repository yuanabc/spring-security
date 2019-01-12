package com.ybinsure.auth.serviceImpl.tool;

import com.ybinsure.auth.constant.ChannelCode;
import com.ybinsure.auth.exception.FailResultException;
import com.ybinsure.auth.model.data.CompanyDO;
import com.ybinsure.auth.model.data.PolicyAreaDO;
import com.ybinsure.auth.model.transfer.param.DatongCompany;
import com.ybinsure.auth.service.data.CompanyService;
import com.ybinsure.auth.service.data.PolicyAreaService;
import com.ybinsure.auth.service.tool.DatongCompanyService;
import com.ybinsure.auth.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DefaultDatongCompanyService implements DatongCompanyService {

    private static final Logger logger = LoggerFactory.getLogger(DefaultDatongCompanyService.class);

    private final PolicyAreaService policyAreaService;
    private final CompanyService companyService;

    @Override
    public void sync(DatongCompany datongCompany) {
        if (datongCompany == null) {
            return;
        }
        logger.info("大童机构同步: 机构数据---{}", JsonUtil.toJson(datongCompany).orElse(""));
        Optional<CompanyDO> existCompany = companyService.query(datongCompany.getConvertComCode(), ChannelCode.DA_TONG);
        if (existCompany.isPresent()) {
            updateOperate(datongCompany,existCompany.get());
        } else {
            insertOperate(datongCompany);
        }
    }

    private void updateOperate(DatongCompany datongCompany, CompanyDO existCompany) {
        // 需要更新父级机构
        if (!StringUtils.equals(datongCompany.getConvertComCode(), existCompany.getOldCode())) {
            logger.info("大童机构同步---更新机构---不支持修改父级机构---{}", datongCompany.getComCode());
            throw new FailResultException("不支持修改父级机构");
        }
        CompanyDO param = datongCompany.convertUpdate();
        param.setId(existCompany.getId());
        // 需要更新地理位置
        if (!StringUtils.equals(datongCompany.getProvince(), existCompany.getProvince()) || !StringUtils.equals(datongCompany.getCity(), existCompany.getCity())) {
            param.setAreaCode(getAreaCode(param));
        }
        logger.info("大童机构同步---更新机构---{}", JsonUtil.toJson(param));
        if (this.companyService.update(param)) {
            logger.info("大童机构同步---更新机构成功");
        } else {
            logger.info("大童机构同步---更新机构失败");
            throw new FailResultException("更新机构失败");
        }
    }

    private void insertOperate(DatongCompany datongCompany) {
        CompanyDO companyDO = datongCompany.convertInsert();
        companyDO.setAreaCode(getAreaCode(companyDO));
        companyDO.setParentId(getParentId(datongCompany));
        logger.info("大童机构同步---新增机构---{}", JsonUtil.toJson(companyDO).orElse(""));
        if (this.companyService.insert(companyDO).isPresent()) {
            logger.info("大童机构同步---新增机构成功---{}", datongCompany.getComCode());
        } else {
            logger.info("大童机构同步---新增机构失败---{}", datongCompany.getComCode());
            throw new FailResultException("新增机构失败");
        }
    }

    private String getAreaCode(CompanyDO companyDO) {
        List<PolicyAreaDO> policyAreaDOS = this.policyAreaService.queryAll().orElseGet(ArrayList::new);
        PolicyAreaDO match = policyAreaDOS
                .stream()
                .filter(policyAreaDO -> StringUtils.equals(policyAreaDO.getDistrictCode(), companyDO.getCity()))
                .findAny()
                .orElseGet(
                        () -> policyAreaDOS
                                .stream()
                                .filter(policyAreaDO -> StringUtils.equals(policyAreaDO.getDistrictCode(), companyDO.getProvince()))
                                .findAny()
                                .orElseGet(PolicyAreaDO::new)
                );
        return match.getAreaCode();
    }

    private String getParentId(DatongCompany datongCompany) {
        Optional<String> parentId = companyService.query(datongCompany.getConvertUpComCode(), ChannelCode.DA_TONG).map(CompanyDO::getId);
        if (!parentId.isPresent()) {
            logger.info("大童机构同步： 查询父级机构失败---{}", JsonUtil.toJson(datongCompany.convertUpdate()));
            throw new FailResultException("查询父级机构失败");
        }
        return parentId.get();
    }
}
