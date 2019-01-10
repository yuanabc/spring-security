package com.ybinsure.icar.user.mapper.extend;

import com.github.pagehelper.Page;
import com.ybinsure.icar.user.mapper.data.UserDOMapper;
import com.ybinsure.icar.user.model.dto.UserPerformanceDTO;
import com.ybinsure.icar.user.model.param.BonusParam;
import com.ybinsure.icar.user.model.vo.AccountVO;
import com.ybinsure.icar.user.model.vo.BonusVO;
import com.ybinsure.icar.user.model.vo.PerformanceVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 用户查询扩展
 *
 * @author HANHT
 * @version 2018/7/7 11:52
 */
@Repository
public interface UserExtendMapper extends UserDOMapper {

    /**
     * 查询用户业绩
     *
     * @param dto 入参对象
     * @return 业绩数据
     */
    PerformanceVO selectUserPerformance(@Param("record") UserPerformanceDTO dto);

    /**
     * 查询用户业绩
     *
     * @param dto 入参对象
     * @return 业绩数据
     */
    PerformanceVO selectCGPerformanceByCG(@Param("record") UserPerformanceDTO dto);

    /**
     * 查询森锐用户账户信息
     *
     * @param userId 用户id
     * @return 业绩数据
     */
    PerformanceVO searchAccountInfo(String userId);

    /**
     * 查询森锐奖金列表
     *
     * @param param 查询条件
     * @return 奖金列表
     */
    Page<BonusVO> selectGrantByPage(@Param("record") BonusParam param);

    /**
     * 查询业务员信息
     *
     * @param userId 用户ID
     * @return 账户信息
     */
    AccountVO selectAccountInfo(String userId);
}
