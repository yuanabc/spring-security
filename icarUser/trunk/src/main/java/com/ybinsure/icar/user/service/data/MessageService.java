package com.ybinsure.icar.user.service.data;

import com.ybinsure.icar.user.model.PageInfo;
import com.ybinsure.icar.user.model.vo.MessageVO;

import java.util.Optional;

/**
 * 消息服务接口
 *
 * @author HANHT
 * @version 2018/7/10 21:30
 */
public interface MessageService {

    Optional<PageInfo<MessageVO>> queryUserNotify(PageInfo param);
}
