package com.lin.xxux.service.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.xxux.model.product.SkuImage;
import com.lin.xxux.service.product.mapper.SkuImageMapper;
import com.lin.xxux.service.product.service.SkuImageService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author linsz
* @description 针对表【sku_image(商品图片)】的数据库操作Service实现
* @createDate 2023-12-11 10:37:41
*/
@Service
public class SkuImageServiceImpl extends ServiceImpl<SkuImageMapper, SkuImage>
    implements SkuImageService {

    /**
     * 根据skuId查询sku图片列表
     *
     * @param skuId
     * @return
     */
    @Override
    public List<SkuImage> findBySkuId(Long skuId) {
        return this.baseMapper.selectList(new LambdaQueryWrapper<SkuImage>().eq(SkuImage::getSkuId, skuId));
    }
}




