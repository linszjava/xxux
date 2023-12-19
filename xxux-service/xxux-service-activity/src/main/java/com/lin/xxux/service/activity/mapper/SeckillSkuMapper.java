package com.lin.xxux.service.activity.mapper;

import com.lin.xxux.model.activity.SeckillSku;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.xxux.vo.activity.SeckillSkuVo;

import java.util.List;

/**
* @author linsz
* @description 针对表【seckill_sku(秒杀活动商品关联)】的数据库操作Mapper
* @createDate 2023-12-26 09:21:05
* @Entity com.lin.xxux.model.activity.SeckillSku
*/
public interface SeckillSkuMapper extends BaseMapper<SeckillSku> {

    void rollBackStock(Long skuId, Integer skuNum);

    Integer minusStock(Long seckillSkuId, Integer skuNum);

    List<SeckillSkuVo> findSeckillSkuListByDate(String date);
}




