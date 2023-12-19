package com.lin.xxux.service.product.controller;

import com.lin.xxux.model.product.Category;
import com.lin.xxux.model.product.SkuInfo;
import com.lin.xxux.service.product.service.CategoryService;
import com.lin.xxux.service.product.service.SkuInfoService;
import io.swagger.annotations.ApiOperation;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>TODO</p>
 *
 * @author linsz
 * @version v1.0
 * @date 2023/12/18 02:38
 */
@RestController
@RequestMapping("api/product")
//@SuppressWarnings({"unchecked", "rawtypes"})
public class ProductInnerController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SkuInfoService skuInfoService;

    @ApiOperation(value = "根据分类id获取分类信息")
    @GetMapping("inner/getCategory/{categoryId}")
    public Category getCategory(@PathVariable Long categoryId) {
        return categoryService.getById(categoryId);
    }

    @ApiOperation(value = "根据skuId获取sku信息")
    @GetMapping("inner/getSkuInfo/{skuId}")
    public SkuInfo getSkuInfo(@PathVariable("skuId") Long skuId) {
        return skuInfoService.getById(skuId);
    }

    @ApiOperation("批量获取sku信息")
    @PostMapping("inner/findSkuInfoList")
    public List<SkuInfo> findSkuInfoList(@RequestBody List<Long> skuIdList) {
        return skuInfoService.findSkuInfoList(skuIdList);
    }

    @ApiOperation(value = "根据关键字获取sku列表")
    @GetMapping("inner/findSkuInfoByKeyword/{keyword}")
    public List<SkuInfo> findSkuInfoByKeyword(@PathVariable("keyword") String keyword) {
        return skuInfoService.findSkuInfoByKeyword(keyword);
    }
}
