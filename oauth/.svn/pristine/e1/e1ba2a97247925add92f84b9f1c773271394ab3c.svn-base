package com.ybinsure.auth.endpoint.tool;

import com.ybinsure.auth.bean.property.HostProperty;
import com.ybinsure.auth.bean.property.PathProperty;
import com.ybinsure.auth.constant.ApiPath;
import com.ybinsure.auth.exception.FailResultException;
import com.ybinsure.auth.model.transfer.file.FileUploadResponse;
import com.ybinsure.auth.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;

@RestController
public class FileEndpoint {

    private final Logger logger = LoggerFactory.getLogger(FileEndpoint.class);
    private String defaultCallBack;

    private final RestTemplate restTemplate;
    private final HostProperty hostProperty;
    private final PathProperty pathProperty;

    @Autowired
    public FileEndpoint(RestTemplate restTemplate, HostProperty hostProperty, PathProperty pathProperty) {
        this.hostProperty = hostProperty;
        this.restTemplate = restTemplate;
        this.pathProperty = pathProperty;
        defaultCallBack = "?uploadHandle=" + hostProperty.getCallback() + ApiPath.GUEST_IMAGE_UPLOAD_CALL_BACK;
    }

    @PostMapping(ApiPath.GUEST_IMAGE_UPLOAD_CALL_BACK)
    public FileUploadResponse callBack(MultipartHttpServletRequest request) {
        String fileName = request.getParameter("file_name");
        String filePath = request.getParameter("file_path");
        logger.info("上传文件参数: {}", JsonUtil.toJson(request.getParameterMap()).orElse(""));
        FileUploadResponse fileUploadResponse = new FileUploadResponse();
        fileUploadResponse.setName(fileName);
        fileUploadResponse.setUrl(hostProperty.getFile() + replaceUrl(filePath));
        return fileUploadResponse;
    }

    @PostMapping(ApiPath.IMAGE_UPLOAD_UP)
    public FileUploadResponse upload(MultipartHttpServletRequest request) throws IOException {
        MultipartFile multipartFile = request.getFile("file");
        if (multipartFile.isEmpty()) {
            throw new FailResultException("读取上传文件失败");
        }

        logger.info("接受上传文件, name: {}, size: {}", multipartFile.getOriginalFilename(), multipartFile.getSize());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("file", new ByteArrayResource(multipartFile.getBytes()){
            @Override
            public String getFilename() {
                return multipartFile.getOriginalFilename();
            }
        });
        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(param, httpHeaders);
        ResponseEntity<FileUploadResponse> responseEntity =
                restTemplate.exchange(hostProperty.getFile() + pathProperty.getUpload() + defaultCallBack, HttpMethod.POST, httpEntity, FileUploadResponse.class);
        FileUploadResponse body = responseEntity.getBody();
        if (!responseEntity.getStatusCode().equals(HttpStatus.OK) ||  body == null) {
            logger.info("上传文件失败,name: {}, size: {}", multipartFile.getOriginalFilename(), multipartFile.getSize());
            throw new FailResultException("上传文件失败");
        }
        return body;
    }

    private String replaceUrl(String url) {
        return url.replace("/s/files", "");
    }

}
