package com.lin.xxux.service.product.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * <p>TODO</p>
 *
 * @author linsz
 * @version v1.0
 * @date 2023/12/15 17:00
 */
public interface FileUploadService {

    /**
     * 文件上传返回文件地址
     * @param file
     * @return
     */
    String uploadFile(MultipartFile file);
}
