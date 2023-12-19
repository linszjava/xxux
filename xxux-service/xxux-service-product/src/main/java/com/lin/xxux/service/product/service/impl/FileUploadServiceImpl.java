package com.lin.xxux.service.product.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.lin.xxux.common.utils.exception.CusException;
import com.lin.xxux.common.utils.file.MinioConst;
import com.lin.xxux.common.utils.file.MinioUtil;
import com.lin.xxux.service.product.service.FileUploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>TODO</p>
 *
 * @author linsz
 * @version v1.0
 * @date 2023/12/15 17:01
 */
@Service
@Slf4j
public class FileUploadServiceImpl implements FileUploadService {
    /**
     * 文件上传返回文件地址
     *
     * @param file
     * @return
     */
    @Override
    public String uploadFile(MultipartFile file) {
        MinioUtil minioUtil = new MinioUtil();
//        if (!minioUtil.bucketExists(MinioConst.BUCKET_NAME)) {
//            minioUtil.makeBucket(MinioConst.BUCKET_NAME);
//        }
        String fileUrl = minioUtil.getFileUrl(minioUtil.uploadFile(file, MinioConst.BUCKET_NAME));
        log.info("文件上传成功，文件地址为：{}",fileUrl);
        if (ObjectUtil.isEmpty(fileUrl)) {
            throw new CusException("文件上传失败");
        }
        return fileUrl;
    }
}
