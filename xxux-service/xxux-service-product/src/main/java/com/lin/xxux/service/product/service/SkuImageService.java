package com.lin.xxux.service.product.service;

import com.lin.xxux.model.product.SkuImage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author linsz
* @description 针对表【sku_image(商品图片)】的数据库操作Service
* @createDate 2023-12-11 10:37:41
*/
public interface SkuImageService extends IService<SkuImage> {

    /**
     * 根据skuId查询sku图片列表
     * @param skuId
     * @return
     */
    List<SkuImage> findBySkuId(Long skuId);

}
