package com.lin.xxux.service.product.service;

import com.lin.xxux.model.product.SkuAttrValue;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author linsz
* @description 针对表【sku_attr_value(spu属性值)】的数据库操作Service
* @createDate 2023-12-11 10:37:41
*/
public interface SkuAttrValueService extends IService<SkuAttrValue> {

    /**
     * 根据skuId查询sku属性值列表
     * @param skuId
     * @return
     */
    List<SkuAttrValue> findBySkuId(Long skuId);

}
