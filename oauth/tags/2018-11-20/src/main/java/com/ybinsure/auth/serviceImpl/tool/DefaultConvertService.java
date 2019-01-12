package com.ybinsure.auth.serviceImpl.tool;

import com.github.pagehelper.PageHelper;
import com.ybinsure.auth.mapper.auto.CompanyDOMapper;
import com.ybinsure.auth.mapper.auto.UserDOMapper;
import com.ybinsure.auth.model.data.CompanyDO;
import com.ybinsure.auth.model.data.CompanyDOExample;
import com.ybinsure.auth.model.data.UserDO;
import com.ybinsure.auth.model.data.UserDOExample;
import com.ybinsure.auth.service.data.CompanyService;
import com.ybinsure.auth.service.data.UserService;
import com.ybinsure.auth.service.tool.ConvertService;
import com.ybinsure.auth.service.tool.TimeSequenceService;
import com.ybinsure.auth.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DefaultConvertService implements ConvertService {

    private final static Logger logger = LoggerFactory.getLogger(DefaultConvertService.class);
    private final UserDOMapper userDOMapper;
    private final UserService userService;
    private final CompanyDOMapper companyDOMapper;
    private final CompanyService companyService;
    private final TimeSequenceService timeSequenceService;

    @Override
    public void convertPassword() {
    }

    @Override
    public void generateCompanyCode() {
        CompanyDOExample example = new CompanyDOExample();
        example.or().andSequenceIsNull();
        List<CompanyDO> companyDOS = companyDOMapper.selectByExample(example).stream().limit(90000).collect(Collectors.toList());
        if (companyDOS.isEmpty()) {
            return;
        }
        List<String> sequences = timeSequenceService.getStepSequence(TimeSequenceService.COMPANY_TYPE, (long) companyDOS.size());
        for (int i = 0; i < companyDOS.size(); i++) {
            CompanyDO param = new CompanyDO();
            param.setId(companyDOS.get(i).getId());
            param.setSequence(sequences.get(i));
            boolean result = companyService.update(param);
            logger.info("update company - {}", JsonUtil.toJson(param).orElse(""));
            logger.info("update company result - {}", result);
        }
    }

    @Override
    public void generateUserCode(int page, int size) {
        UserDOExample example = new UserDOExample();
        example.or().andSequenceIsNull();
        example.setOrderByClause("id");
        PageHelper.startPage(page, size);
        List<UserDO> userDOS = userDOMapper.selectByExample(example);
        if (userDOS.isEmpty()) {
            return;
        }
        List<String> sequences = timeSequenceService.getStepSequence(TimeSequenceService.USER_TYPE, (long) size);
        for (int i = 0; i < userDOS.size(); i++) {
            UserDO param = new UserDO();
            param.setId(userDOS.get(i).getId());
            param.setSequence(sequences.get(i));
            boolean result = userService.update(param);
            logger.info("update user - {}", JsonUtil.toJson(param).orElse(""));
            logger.info("update company result - {}", result);
        }
    }
}
