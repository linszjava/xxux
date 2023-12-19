package com.lin.xxux.service.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.xxux.model.product.SkuPoster;
import com.lin.xxux.service.product.mapper.SkuPosterMapper;
import com.lin.xxux.service.product.service.SkuPosterService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author linsz
* @description 针对表【sku_poster(商品海报表)】的数据库操作Service实现
* @createDate 2023-12-11 10:37:41
*/
@Service
public class SkuPosterServiceImpl extends ServiceImpl<SkuPosterMapper, SkuPoster>
    implements SkuPosterService {

    /**
     * 根据skuId查询sku海报列表
     *
     * @param skuId
     * @return
     */
    @Override
    public List<SkuPoster> findBySkuId(Long skuId) {

        return this.baseMapper.selectList(new LambdaQueryWrapper<SkuPoster>().eq(SkuPoster::getSkuId, skuId));
    }
}




