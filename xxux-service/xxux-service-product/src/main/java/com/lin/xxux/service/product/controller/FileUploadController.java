package com.lin.xxux.service.product.controller;

import com.lin.xxux.common.service.result.Result;
import com.lin.xxux.service.product.service.FileUploadService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>TODO</p>
 *
 * @author linsz
 * @version v1.0
 * @date 2023/12/15 17:00
 */
@Api(value = "文件上传管理", tags = "文件上传管理")
@RestController
@RequestMapping(value="/admin/product")
//@CrossOrigin
public class FileUploadController {

    @Autowired
    private FileUploadService fileUploadService;

    /**
     * 文件上传返回文件地址
     * @param file
     * @return
     */
    @PostMapping(value = "/fileUpload")
    @ApiOperation(value = "文件上传返回文件地址")
    public Result<String> uploadFile(@RequestParam(value = "file") MultipartFile file){
        String resultUrl = fileUploadService.uploadFile(file);
        return Result.ok(resultUrl);
    }
}
