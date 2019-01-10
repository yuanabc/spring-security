package com.ybinsure.icar.user.service.data;

import com.ybinsure.icar.user.model.vo.FileVO;

import java.util.List;
import java.util.Optional;

/**
 * 文件查询服务
 *
 * @author HANHT
 * @version 2018/7/9 11:20
 */
public interface FileService {

    /**
     * 查询保单关联文件
     *
     * @param orderId 订单号
     * @return 文件列表
     */
    Optional<List<FileVO>> queryPolicyImages(String orderId);
}
