package com.lin.xxux.service.client.product.service;

import com.lin.xxux.model.product.Category;
import com.lin.xxux.model.product.SkuInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>TODO</p>
 *
 * @author linsz
 * @version v1.0
 * @date 2023/12/18 02:53
 */
@FeignClient("xxux-service-product")
public interface ProductFeignClientService {


    @GetMapping("/api/product/inner/getCategory/{categoryId}")
    public Category getCategory(@PathVariable("categoryId") Long categoryId);

    @GetMapping("/api/product/inner/getSkuInfo/{skuId}")
    public SkuInfo getSkuInfo(@PathVariable("skuId") Long skuId);

    /**
     * 批量获取sku信息
     * @param skuIdList
     * @return
     */
    @PostMapping("/api/product/inner/findSkuInfoList")
    List<SkuInfo> findSkuInfoList(@RequestBody List<Long> skuIdList);

    /**
     * 根据关键字获取sku列表，活动使用
     * @param keyword
     * @return
     */
    @GetMapping("/api/product/inner/findSkuInfoByKeyword/{keyword}")
    List<SkuInfo> findSkuInfoByKeyword(@PathVariable("keyword") String keyword);


}
