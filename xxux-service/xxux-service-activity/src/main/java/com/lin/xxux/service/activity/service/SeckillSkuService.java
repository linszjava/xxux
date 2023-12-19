package com.lin.xxux.service.activity.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lin.xxux.model.activity.SeckillSku;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.xxux.vo.activity.SeckillSkuQueryVo;
import com.lin.xxux.vo.activity.SeckillSkuVo;
import com.lin.xxux.vo.product.SkuStockLockVo;

import java.util.List;

/**
* @author linsz
* @description 针对表【seckill_sku(秒杀活动商品关联)】的数据库操作Service
* @createDate 2023-12-26 09:21:05
*/
public interface SeckillSkuService extends IService<SeckillSku> {

    IPage<SeckillSku> selectPage(Page<SeckillSku> pageParam, SeckillSkuQueryVo seckillSkuQueryVo);

    void save(List<SeckillSku> seckillSkuList);

    /**
     * 将某日的秒杀列表加载到缓存
     * @param date
     */
    void saveSeckillSkuListToCache(String date);

    /**
     * 从缓存中读取秒杀sku信息
     * @param timeName 场次名称
     */
    List<SeckillSkuVo> findSeckillSkuListFromCache(String timeName);

    /**
     * 根据skuId获取秒杀sku信息
     * @param skuId
     * @return
     */
    SeckillSkuVo getSeckillSkuVo(Long skuId);

    Boolean checkAndMinusStock(List<SkuStockLockVo> skuStockLockVoList, String orderToken);

    void rollBackStock(String orderNo);

}
