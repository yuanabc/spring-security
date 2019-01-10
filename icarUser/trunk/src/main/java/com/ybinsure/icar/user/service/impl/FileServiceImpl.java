package com.ybinsure.icar.user.service.impl;

import com.ybinsure.icar.user.mapper.data.FileDOMapper;
import com.ybinsure.icar.user.model.data.FileDO;
import com.ybinsure.icar.user.model.data.FileDOExample;
import com.ybinsure.icar.user.model.vo.FileVO;
import com.ybinsure.icar.user.service.data.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 文件查询服务实现
 *
 * @author HANHT
 * @version 2018/7/9 11:21
 */
@Service
public class FileServiceImpl implements FileService {

    private final FileDOMapper fileDOMapper;

    @Autowired
    public FileServiceImpl(FileDOMapper fileDOMapper) {
        this.fileDOMapper = fileDOMapper;
    }

    @Override
    public Optional<List<FileVO>> queryPolicyImages(String orderId) {
        FileDOExample fileDOExample = new FileDOExample();
        fileDOExample.or().andPidEqualTo(orderId);
        List<FileDO> files = fileDOMapper.selectByExample(fileDOExample);
        if (files == null || files.isEmpty()) {

            return Optional.empty();
        }

        List<FileVO> images = new ArrayList<>();
        files.forEach(o -> {
            FileVO vo = new FileVO();
            vo.setUrl(o.getFiles());
            vo.setNamed(o.getNamed());
            vo.setFlag(o.getFlag());
            images.add(vo);
        });

        return Optional.of(images);
    }
}
