package com.lin.xxux.service.search.service;

/**
 * <p>TODO</p>
 *
 * @author linsz
 * @version v1.0
 * @date 2023/12/18 03:04
 */
public interface SkuService {

    /**
     * 上架商品列表
     * @param skuId
     */
    void upperSku(Long skuId);

    /**
     * 下架商品列表
     * @param skuId
     */
    void lowerSku(Long skuId);
}
