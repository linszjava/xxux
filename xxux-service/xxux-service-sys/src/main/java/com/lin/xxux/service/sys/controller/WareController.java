package com.lin.xxux.service.sys.controller;

import com.lin.xxux.common.service.result.Result;
import com.lin.xxux.service.sys.service.WareService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>TODO</p>
 *
 * @author linsz
 * @version v1.0
 * @date 2023/12/7 08:51
 */
@RestController
@RequestMapping("/admin/sys/ware")
@Api(tags = "Ware管理")
@CrossOrigin
public class WareController {

    @Autowired
    private WareService wareService;

    @ApiOperation("获得全部仓库")
    @GetMapping("/findAllList")
    public Result findAllWare() {
        return Result.ok(wareService.list());
    }
}
