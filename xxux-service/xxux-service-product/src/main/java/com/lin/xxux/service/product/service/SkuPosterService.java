package com.lin.xxux.service.product.service;

import com.lin.xxux.model.product.SkuPoster;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author linsz
* @description 针对表【sku_poster(商品海报表)】的数据库操作Service
* @createDate 2023-12-11 10:37:41
*/
public interface SkuPosterService extends IService<SkuPoster> {

    /**
     * 根据skuId查询sku海报列表
     * @param skuId
     * @return
     */
    List<SkuPoster> findBySkuId(Long skuId);

}
