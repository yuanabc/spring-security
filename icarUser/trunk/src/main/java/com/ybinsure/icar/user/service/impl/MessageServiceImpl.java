package com.ybinsure.icar.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.ybinsure.icar.user.constant.SwitchCode;
import com.ybinsure.icar.user.mapper.data.MessageDOMapper;
import com.ybinsure.icar.user.model.PageInfo;
import com.ybinsure.icar.user.model.data.MessageDO;
import com.ybinsure.icar.user.model.data.MessageDOExample;
import com.ybinsure.icar.user.model.vo.MessageVO;
import com.ybinsure.icar.user.service.data.MessageService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 消息接口实现
 *
 * @author HANHT
 * @version 2018/7/10 21:30
 */
@Service
public class MessageServiceImpl implements MessageService {

    private final MessageDOMapper messageDOMapper;

    @Autowired
    public MessageServiceImpl(MessageDOMapper messageDOMapper) {
        this.messageDOMapper = messageDOMapper;
    }

    @Override
    public Optional<PageInfo<MessageVO>> queryUserNotify(PageInfo param) {
        param.setOrderBy("id");
        param.setSortord(1);

        PageHelper.startPage(param.getPageNum(), param.getPageSize(), param.assembleSort());

        MessageDOExample example = new MessageDOExample();
        example.or().andReceiveIdEqualTo(param.getAuth()).andStatusEqualTo(SwitchCode.DISABLE);

        List<MessageDO> data = messageDOMapper.selectByExample(example);
        if (data == null || data.isEmpty()) {

            return Optional.empty();
        }

        // TODO 更新用户消息为已读？？？
        MessageDO messageDO = new MessageDO();
        messageDO.setStatus(SwitchCode.ENABLE);
        messageDOMapper.updateByExampleSelective(messageDO, example);

        List<MessageVO> result = new ArrayList<>(16);
        data.forEach(o -> {
            MessageVO vo = new MessageVO();
            result.add(vo);
            BeanUtils.copyProperties(o, vo);
            vo.setMessageId(o.getId());
        });

        return Optional.of(new PageInfo<>(result));
    }
}
