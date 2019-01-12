package com.ybinsure.auth.serviceImpl.data;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ybinsure.auth.constant.ChannelCode;
import com.ybinsure.auth.constant.OrderCode;
import com.ybinsure.auth.constant.StatusCode;
import com.ybinsure.auth.exception.FailResultException;
import com.ybinsure.auth.mapper.auto.RoleDOMapper;
import com.ybinsure.auth.model.data.ChannelDO;
import com.ybinsure.auth.model.data.RoleDO;
import com.ybinsure.auth.model.data.RoleDOExample;
import com.ybinsure.auth.model.transfer.page.PageParam;
import com.ybinsure.auth.model.transfer.page.PageResult;
import com.ybinsure.auth.service.data.ChannelService;
import com.ybinsure.auth.service.data.RoleService;
import com.ybinsure.auth.service.data.UserRelateRoleService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.ybinsure.auth.model.data.RoleDOExample.Criteria;

@Component
@RequiredArgsConstructor
public class DefaultRoleService implements RoleService {

    private final RoleDOMapper roleDOMapper;
    private final ChannelService channelService;
    private final UserRelateRoleService userRelateRoleService;

    @Override
    public Optional<String> insert(RoleDO roleDO) {
        if (roleDO != null) {
            roleDO.setType(RoleDO.ROLE_TYPE_NORMAL);
        }
        return insertOperate(roleDO);
    }

    @Override
    public Optional<String> insertAdmin(RoleDO roleDO) {
        if (roleDO != null) {
            roleDO.setType(RoleDO.ROLE_TYPE_ADMIN);
        }
        if (roleDO != null && queryAdminRole(roleDO.getChannelCode()).isPresent()) {
            throw new FailResultException("该渠道已经存在管理员角色");
        }
        return insertOperate(roleDO);
    }

    private Optional<String> insertOperate(RoleDO roleDO) {
        if (roleDO == null || !channelService.isExist(ChannelDO.createInstanceWithCode(roleDO.getChannelCode()))) {
            return Optional.empty();
        }
        roleDO.setCreateTime(System.currentTimeMillis());
        roleDO.setUpdateTime(System.currentTimeMillis());
        if (roleDOMapper.insertSelective(roleDO) > 0) {
            return Optional.of(roleDO.getId());
        }
        return Optional.empty();
    }

    @Override
    public boolean update(RoleDO roleDO) {
        if (StringUtils.isBlank(roleDO.getId())) {
            return false;
        }
        roleDO.setDeleted(null);
        roleDO.setType(null);
        roleDO.setUpdateTime(System.currentTimeMillis());
        return roleDOMapper.updateByPrimaryKeySelective(roleDO) > 0;
    }

    @Override
    public Optional<List<RoleDO>> queryByChannelCode(String channelCode) {
        if (StringUtils.isBlank(channelCode)) {
            return Optional.empty();
        }
        RoleDOExample example = new RoleDOExample();
        example.setOrderByClause("type");
        example.or()
                .andChannelCodeEqualTo(channelCode)
                .andStatusEqualTo(StatusCode.ENABLE)
                .andDeletedEqualTo(StatusCode.DISABLE);
        return Optional.ofNullable(roleDOMapper.selectByExample(example));
    }

    @Override
    public Optional<List<RoleDO>> queryByChannelCodes(List<String> param) {
        return Optional.ofNullable(param)
                .filter(channelCodes -> !channelCodes.isEmpty())
                .map(channelCodes -> {
                    RoleDOExample example = new RoleDOExample();
                    example.or().andChannelCodeIn(param)
                            .andStatusEqualTo(StatusCode.ENABLE)
                            .andDeletedEqualTo(StatusCode.DISABLE);
                    return roleDOMapper.selectByExample(example);
                });
    }

    @Override
    public Optional<PageResult<List<RoleDO>>> queryWithPage(PageParam<RoleDO> pageParam) {
        if (queryWithPageRequire(pageParam)) {
            return Optional.empty();
        }
        RoleDO model = pageParam.getModel();
        RoleDOExample example = new RoleDOExample();
        example.setOrderByClause(getOrderClause(pageParam.getModel()));
        Criteria criteria = example.createCriteria();
        criteria.andChannelCodeEqualTo(model.getChannelCode());
        criteria.andDeletedEqualTo(StatusCode.DISABLE);
        if (model.getStatus() != null) {
            criteria.andStatusEqualTo(model.getStatus());
        }
        if (model.getTemplate() != null) {
            criteria.andTemplateEqualTo(model.getTemplate());
        }
        if (StringUtils.isNotBlank(model.getName())) {
            criteria.andNameLike("%"+ model.getName().trim() + "%");
        }
        PageHelper.startPage(pageParam.getPage(), pageParam.getSize());
        List<RoleDO> roleDOS = roleDOMapper.selectByExample(example);
        long count = ((Page) roleDOS).getTotal();
        return Optional.of(PageResult.instance(count, roleDOS));
    }

    private String getOrderClause(RoleDO model) {
        if (model == null || OrderCode.DESC == model.getCreateTime()) {
            return "create_time desc";
        }
        return "create_time asc";
    }

    @Override
    public Optional<List<RoleDO>> queryTemplateRole() {
        RoleDOExample example = new RoleDOExample();
        example.or().andChannelCodeEqualTo(ChannelCode.YUEBAO)
                .andDeletedEqualTo(StatusCode.DISABLE)
                .andTemplateEqualTo(StatusCode.ENABLE);
        return Optional.ofNullable(roleDOMapper.selectByExample(example));
    }

    @Override
    public Optional<RoleDO> queryAdminRole(String channelCode) {
        if (StringUtils.isBlank(channelCode)) {
            return Optional.empty();
        }
        RoleDOExample example = new RoleDOExample();
        example.or().andChannelCodeEqualTo(channelCode)
                .andTypeEqualTo(RoleDO.ROLE_TYPE_ADMIN)
                .andDeletedEqualTo(StatusCode.DISABLE);
        List<RoleDO> roles = roleDOMapper.selectByExample(example);
        if (roles == null || roles.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(roles.get(0));
    }

    @Override
    public boolean exist(String name, String channelCode) {
        if (StringUtils.isAnyBlank(name,  channelCode)) {
            return false;
        }
        RoleDOExample example = new RoleDOExample();
        example.or().andNameEqualTo(name)
                .andChannelCodeEqualTo(channelCode)
                .andDeletedEqualTo(StatusCode.DISABLE);
        return !roleDOMapper.selectByExample(example).isEmpty();
    }

    @Override
    public boolean exist(String id) {
        if (StringUtils.isBlank(id)) {
            return false;
        }
        RoleDOExample example = new RoleDOExample();
        example.or().andIdEqualTo(id);
        return roleDOMapper.countByExample(example) > 0;
    }

    @Override
    public Optional<RoleDO> queryById(String id) {
        if (StringUtils.isBlank(id)) {
            return Optional.empty();
        }
        return Optional.of(roleDOMapper.selectByPrimaryKey(id));
    }

    private boolean queryWithPageRequire(PageParam<RoleDO> pageParam) {
        return pageParam.blank() ||
                pageParam.getModel() == null ||
                StringUtils.isBlank(pageParam.getModel().getChannelCode());
    }

    @Override
    @Transactional
    public boolean delete(String roleId) {
        if (StringUtils.isBlank(roleId)) {
            return false;
        }
        RoleDO param = new RoleDO();
        param.setId(roleId);
        param.setDeleted(StatusCode.ENABLE);
        boolean res = roleDOMapper.updateByPrimaryKeySelective(param) > 0;
        if (!res) {
            return false;
        }
        boolean deleteResult = userRelateRoleService.deleteByRoleId(roleId);
        if (!deleteResult) {
            throw new FailResultException("删除关联角色失败");
        }
        return true;
    }

}
