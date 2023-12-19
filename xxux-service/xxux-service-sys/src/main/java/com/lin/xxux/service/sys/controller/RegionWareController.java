package com.lin.xxux.service.sys.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lin.xxux.common.service.result.Result;
import com.lin.xxux.model.sys.RegionWare;
import com.lin.xxux.service.sys.service.RegionWareService;
import com.lin.xxux.vo.sys.RegionWareQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
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
@RequestMapping("/admin/sys/regionWare")
@Api(tags = "地区仓库管理")
//@CrossOrigin
public class RegionWareController {

    @Autowired
    private RegionWareService regionWareService;

    @ApiOperation(value = "根据传入参数分页查询地区仓库信息")
    @GetMapping("/{page}/{limit}")
    public Result getRegionWarePage(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable("page") Long page,    // 当前页码
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable("limit") Long limit,  // 每页记录数
            @ApiParam(name = "regionWareQueryVo", value = "查询对象", required = false)
            RegionWareQueryVo regionWareQueryVo) {
        IPage<RegionWare> regionWares = regionWareService.selectRegionWarePage(page, limit, regionWareQueryVo);
        return Result.ok(regionWares);
    }

    @ApiOperation(value = "添加开通区域")
    @PostMapping("/save")
    public Result saveRegionOpened(@RequestBody RegionWare regionWare) {
        regionWareService.saveRegionOpened(regionWare);
        return Result.ok();
    }

    @ApiOperation(value = "删除开通区域")
    @DeleteMapping("/delete/{id}")
    public Result deleteRegionOpened(@PathVariable("id") Long id) {
        regionWareService.removeById(id);
        return Result.ok();
    }

    @ApiOperation("取消开通区域")
    @PutMapping("/updateStatus/{id}/{status}")
    public Result updateStatus (@PathVariable("id") Long id, @PathVariable("status") Integer status) {
        regionWareService.updateStatus(id, status);
        return Result.ok();
    }
}
