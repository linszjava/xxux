package com.lin.xxux.service.product.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lin.xxux.common.service.result.Result;
import com.lin.xxux.model.product.SkuInfo;
import com.lin.xxux.service.product.service.SkuInfoService;
import com.lin.xxux.vo.product.SkuInfoQueryVo;
import com.lin.xxux.vo.product.SkuInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>TODO</p>
 *
 * @author linsz
 * @version v1.0
 * @date 2023/12/11 10:36
 */
@Api(value = "SkuInfo管理", tags = "商品Sku管理")
@RestController
@RequestMapping(value="/admin/product/skuInfo")
//@CrossOrigin
public class SkuInfoController {

    @Autowired
    private SkuInfoService skuInfoService;

    @ApiOperation(value = "获取sku分页列表")
    @GetMapping("{page}/{limit}")
    public Result<IPage<SkuInfo>> index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,

            @ApiParam(name = "skuInfoQueryVo", value = "查询对象", required = false)
            SkuInfoQueryVo skuInfoQueryVo) {
        Page<SkuInfo> pageParam = new Page<>(page, limit);
        IPage<SkuInfo> pageModel = skuInfoService.selectPage(pageParam, skuInfoQueryVo);
        return Result.ok(pageModel);
    }

    //商品添加方法
    @ApiOperation(value = "新增商品")
    @PostMapping("save")
    public Result save(@RequestBody SkuInfoVo skuInfoVo) {
        skuInfoService.saveSkuInfo(skuInfoVo);
        return Result.ok();
    }

    @ApiOperation(value = "获取商品")
    @GetMapping("get/{id}")
    public Result<SkuInfoVo> get(@PathVariable Long id) {
        SkuInfoVo skuInfoVo = skuInfoService.getSkuInfoVo(id);
        return Result.ok(skuInfoVo);
    }

    @ApiOperation(value = "修改商品")
    @PutMapping("update")
    public Result updateById(@RequestBody SkuInfoVo skuInfoVo) {
        skuInfoService.updateSkuInfo(skuInfoVo);
        return Result.ok();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        skuInfoService.removeById(id);
        return Result.ok();
    }

    @ApiOperation(value = "根据id列表删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList) {
        skuInfoService.removeByIds(idList);
        return Result.ok();
    }

    /**
     * 商品审核
     * @param skuId
     * @return
     */
    @GetMapping("check/{skuId}/{status}")
    public Result check(@PathVariable("skuId") Long skuId, @PathVariable("status") Integer status) {
        skuInfoService.check(skuId, status);
        return Result.ok();
    }

    /**
     * 商品上架
     * @param skuId
     * @return
     */
    @GetMapping("publish/{skuId}/{status}")
    public Result publish(@PathVariable("skuId") Long skuId,
                          @PathVariable("status") Integer status) {
        skuInfoService.publish(skuId, status);
        return Result.ok();
    }

    //新人专享
    @GetMapping("isNewPerson/{skuId}/{status}")
    public Result isNewPerson(@PathVariable("skuId") Long skuId,
                              @PathVariable("status") Integer status) {
        skuInfoService.isNewPerson(skuId, status);
        return Result.ok();
    }
}
