package com.lin.xxux.common.utils.file;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.ObjectUtil;
import com.lin.xxux.common.utils.enums.ResultEnum;
import com.lin.xxux.common.utils.exception.CusException;
import io.minio.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.UUID;

/**
 * <p>TODO</p>
 *
 * @author linsz
 * @version v1.0
 * @date 2023/11/17 01:25
 */
@Slf4j
public class MinioUtil {



    /**
     * 初始化minio客户端
     *
     * @return
     */
    public MinioClient initClient() {
        MinioClient minioClient = MinioClient.builder()
                .endpoint(MinioConst.ENDPOINT_URL)
                .credentials(MinioConst.ACCESS_KEY, MinioConst.SECRET_KEY)
                .build();
        if (ObjectUtil.isEmpty(minioClient)) {
            log.error("minio客户端初始化失败");
            throw new CusException("minio客户端初始化失败",999);
        }
        log.info("minio客户端初始化成功");
        return minioClient;
    }

    /**
     * 判断bucket是否存在
     */
    public  boolean  bucketExists(String bucketName) {
        MinioClient minioClient = initClient();
        try {
            BucketExistsArgs bucketExistsArgs = BucketExistsArgs.builder().bucket(bucketName).build();
            return minioClient.bucketExists(bucketExistsArgs);
        } catch (Exception e) {
            throw new CusException("判断bucket是否存在失败,{}",e.getMessage());
        }
    }

    /**
     * 创建bucket
     */
    public  void makeBucket(String bucketName) {
        MinioClient minioClient = initClient();
        try {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        } catch (Exception e) {
            throw new CusException(ResultEnum.CONFIG_ERROR);
        }
    }

    /**
     * 上传文件
     */
    public  String uploadFile(MultipartFile multipartFile,String bucketName) {
        MinioClient minioClient = initClient();
        String fileName;
        // 设置存储对象名称
        try {
            String dateDir = DateUtil.format(new Date(), "yyyyMMdd");
            String uuid = UUID.randomUUID().toString().replace("-", "");
            //20230801/443e1e772bef482c95be28704bec58a901.jpg
            fileName = dateDir+"/"+uuid+multipartFile.getOriginalFilename();
            PutObjectArgs putObjectArgs = PutObjectArgs.builder()
                    .bucket(bucketName)
                    .stream(multipartFile.getInputStream(), multipartFile.getInputStream().available(), -1)
                    .object(fileName)
                    .build();
            minioClient.putObject(putObjectArgs) ;
        }catch (Exception e){
            throw new CusException("上传文件失败,{}",e.getMessage());
        }
        return fileName;
    }

    /**
     * 得到文件的真实路径
     */
    public static String getFileUrl(String fileName) {
        return MinioConst.ENDPOINT_URL + "/" + MinioConst.BUCKET_NAME + "/" + fileName;
    }
}
