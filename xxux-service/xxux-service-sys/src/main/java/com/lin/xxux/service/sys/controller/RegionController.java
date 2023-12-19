package com.lin.xxux.service.sys.controller;

import com.lin.xxux.common.service.result.Result;
import com.lin.xxux.model.sys.Region;
import com.lin.xxux.service.sys.service.RegionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>TODO</p>
 *
 * @author linsz
 * @version v1.0
 * @date 2023/12/7 08:51
 */
@RestController
@Api(tags = "区域管理")
@RequestMapping("/admin/sys/region")
@CrossOrigin
public class RegionController {

    @Autowired
    private RegionService regionService;

    @ApiOperation(value = "根据关键字获取地区列表")
    @GetMapping("/findResionByKeyword/{keyword}")
    public Result findResionByKeyword(@PathVariable("keyword") String keyword) {
        List<Region> regions = regionService.findResionByKeyword(keyword);
        return Result.ok(regions);
    }

}
