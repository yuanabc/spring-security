package com.ybinsure.auth.serviceImpl.tool;

import com.github.pagehelper.PageHelper;
import com.ybinsure.auth.constant.UserTypeCode;
import com.ybinsure.auth.enums.CodeTypeEnum;
import com.ybinsure.auth.mapper.data.CompanyDOMapper;
import com.ybinsure.auth.mapper.data.UserDOMapper;
import com.ybinsure.auth.mapper.extend.ExtendUserMapper;
import com.ybinsure.auth.model.data.CompanyDO;
import com.ybinsure.auth.model.data.CompanyDOExample;
import com.ybinsure.auth.model.data.UserDO;
import com.ybinsure.auth.model.data.UserDOExample;
import com.ybinsure.auth.service.data.CompanyService;
import com.ybinsure.auth.service.data.UserService;
import com.ybinsure.auth.service.tool.ConvertService;
import com.ybinsure.auth.service.tool.OrderCodeService;
import com.ybinsure.auth.util.JsonUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DefaultConvertService implements ConvertService {

    private final static Logger logger = LoggerFactory.getLogger(DefaultConvertService.class);
    private final UserDOMapper userDOMapper;
    private final UserService userService;
    private final CompanyDOMapper companyDOMapper;
    private final CompanyService companyService;
    private final ExtendUserMapper extendUserMapper;
    private final PasswordEncoder passwordEncoder;
    private final OrderCodeService orderCodeService;

    @Override
    public void convertPassword() {
        List<UserDO> userDOS = extendUserMapper.queryNotEmptyPasswordUser();
        if (userDOS == null) {
            return;
        }
        userDOS.forEach(userDO -> {
            if (StringUtils.isNotBlank(userDO.getPassword()) && userDO.getPassword().length() == 32) {
                String targetPassword = passwordEncoder.encode(userDO.getPassword());
                logger.info("update password, source: {}, target: {}",userDO.getPassword(), targetPassword);
                userDO.setPassword(targetPassword);
                extendUserMapper.updatePassword(userDO);
            }
        });
    }

    @Override
    public void generateCompanyCode() {
        CompanyDOExample example = new CompanyDOExample();
        example.or().andCodeIsNull();
        List<CompanyDO> companyDOS = companyDOMapper.selectByExample(example).stream().limit(90000).collect(Collectors.toList());
        companyDOS.forEach(companyDO -> {
            Optional<Long> maxCodeOptional = orderCodeService.maxCode(companyDO.getChannelCode(), CodeTypeEnum.SALES, companyService);
            maxCodeOptional.ifPresent(maxCode -> {
                CompanyDO clone = new CompanyDO();
                clone.setId(companyDO.getId());
                clone.setCode(maxCode);
                boolean result = companyService.update(clone);
                logger.info("update company - {}", JsonUtil.toJson(clone).orElse(""));
                logger.info("update company result - {}", result);
            });
        });
    }

    @Override
    public void generateUserCode(int page, int size) {
        UserDOExample example = new UserDOExample();
        example.setOrderByClause("channel_code desc");
        example.or().andCodeIsNull();
        PageHelper.startPage(page, size);
        List<UserDO> userDOS = userDOMapper.selectByExample(example);
        userDOS.forEach(userDO -> {
            CodeTypeEnum type;
            switch (userDO.getUserType()) {
                case UserTypeCode.ADMIN:
                    type = CodeTypeEnum.ADMIN;
                    break;
                case UserTypeCode.USER:
                    type = CodeTypeEnum.USER;
                    break;
                default:
                    type = CodeTypeEnum.SALES;
            }
            Optional<Long> maxCodeOptional = orderCodeService.maxCode(userDO.getChannelCode(), type, userService);
            maxCodeOptional.ifPresent(maxCode -> {
                UserDO clone = new UserDO();
                clone.setId(userDO.getId());
                clone.setCode(maxCode);
                boolean result = userService.update(clone);
                logger.info("update user - {}", JsonUtil.toJson(clone).orElse(""));
                logger.info("update company result - {}", result);
//                if (!result) {
//                    throw new FailResultException("更新失败");
//                }
            });
        });

    }
}
