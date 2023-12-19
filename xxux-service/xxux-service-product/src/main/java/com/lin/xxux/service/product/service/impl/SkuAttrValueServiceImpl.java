package com.lin.xxux.service.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.xxux.model.product.SkuAttrValue;
import com.lin.xxux.service.product.mapper.SkuAttrValueMapper;
import com.lin.xxux.service.product.service.SkuAttrValueService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author linsz
* @description 针对表【sku_attr_value(spu属性值)】的数据库操作Service实现
* @createDate 2023-12-11 10:37:41
*/
@Service
public class SkuAttrValueServiceImpl extends ServiceImpl<SkuAttrValueMapper, SkuAttrValue>
    implements SkuAttrValueService {

    /**
     * 根据skuId查询sku属性值列表
     *
     * @param skuId
     * @return
     */
    @Override
    public List<SkuAttrValue> findBySkuId(Long skuId) {
        return this.baseMapper.selectList(new LambdaQueryWrapper<>(new SkuAttrValue()).eq(SkuAttrValue::getSkuId, skuId));
    }
}




