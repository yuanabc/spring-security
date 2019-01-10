package com.ybinsure.icar.user.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.ybinsure.icar.user.constant.PingAnOrderStatus;
import com.ybinsure.icar.user.constant.PolicyState;
import com.ybinsure.icar.user.constant.RespInfo;
import com.ybinsure.icar.user.mapper.extend.PingAnOrderExtendMapper;
import com.ybinsure.icar.user.model.PageInfo;
import com.ybinsure.icar.user.model.QueryParam;
import com.ybinsure.icar.user.model.data.PingAnOrderDO;
import com.ybinsure.icar.user.model.data.PingAnOrderDOExample;
import com.ybinsure.icar.user.model.vo.OrderVO;
import com.ybinsure.icar.user.service.data.PingAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * 平安订单管理服务实现
 *
 * @author HANHT
 * @version 2018/7/15 12:41
 */
@Service
public class PingAnServiceImpl implements PingAnService {

    private final PingAnOrderExtendMapper pingAnOrderExtendMapper;

    @Autowired
    private Environment env;

    @Autowired
    public PingAnServiceImpl(PingAnOrderExtendMapper pingAnOrderExtendMapper) {
        this.pingAnOrderExtendMapper = pingAnOrderExtendMapper;
    }

    @Override
    public Optional<PageInfo<OrderVO>> queryUserOrder(QueryParam param) {
        Assert.notNull(param.getType(), RespInfo.F511.msg);

        PageHelper.startPage(param.getPageNum(), param.getPageSize(), param.assembleSort());

        // 当前用户id，由于平安测试环境接口返回userId=yndtUid，默认查userId=0的数据
        String userId = "0";
        // 生产环境配置
        final String prod = "prod";
        final String profile = "spring.profiles.active";
        if (Objects.equals(prod, env.getProperty(profile))) {
            userId = param.getAuth();
        }

        PingAnOrderDOExample example = new PingAnOrderDOExample();
        PingAnOrderDOExample.Criteria criteria = example.or();
        criteria.andUserIdEqualTo(userId);
        // 3 4 未支付/5 6 已支付
        if (0 == param.getType()) {
            // 未支付：小于等于4
            criteria.andStatusLessThanOrEqualTo(Byte.valueOf("4"));
        } else {
            // 已支付：大于等于5
            criteria.andStatusGreaterThanOrEqualTo(Byte.valueOf("5"));
        }
        // 添加排序 按订单时间倒序
        example.setOrderByClause("createDate DESC");

        // 查询用户订单
        Page<PingAnOrderDO> pages = pingAnOrderExtendMapper.selectUserOrder(example);
        if (CollectionUtils.isEmpty(pages)) {

            return Optional.empty();
        }

        // 转义结果
        List<OrderVO> res = new ArrayList<>();
        pages.forEach(o -> {
            OrderVO vo = new OrderVO();
            res.add(vo);
            vo.setOrderId(o.getOrderNo());
            vo.setOrderTime(o.getCreateDate());
            vo.setTotalPremium(o.getTotalPremium());
            vo.setLicenseNo(o.getLicenseNo());
            vo.setOwnerName(o.getName());
            Byte status = o.getStatus();
            if (Objects.equals(status, PingAnOrderStatus.INSURE_FAILURE)) {
                status = PolicyState.INSURE_FAILURE;
            } else if (Objects.equals(status, PingAnOrderStatus.INSURE_SUCCESS)) {
                status = PolicyState.INSURE_SUCCESS;
            } else if (Objects.equals(status, PingAnOrderStatus.POLICY_SUCCESS)) {
                status = PolicyState.PAYMENT_SUCCESS;
            } else {
                status = PolicyState.POLICY_FAILURE;
            }
            vo.setPolicyStatus(status);
        });

        PageInfo<OrderVO> voInfo = new PageInfo<OrderVO>(pages);
        voInfo.setList(res);

        return Optional.of(voInfo);
    }
}
