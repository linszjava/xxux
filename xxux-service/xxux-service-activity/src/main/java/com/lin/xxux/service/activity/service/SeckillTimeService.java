package com.lin.xxux.service.activity.service;

import com.lin.xxux.model.activity.SeckillTime;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
* @author linsz
* @description 针对表【seckill_time(秒杀活动场次)】的数据库操作Service
* @createDate 2023-12-26 09:21:05
*/
public interface SeckillTimeService extends IService<SeckillTime> {

    void updateStatus(Long id, Integer status);

    /**
     * 查询秒杀时间段列表放入缓存
     */
    void saveSeckillTimeListToCache();

    /**
     * 从缓存中查询秒杀时间段
     * @return
     */
    List<SeckillTime> findAllSeckillTimeListFromCache();

    /**
     * 获取用户端首页秒杀数据
     *
     * @return
     */
    Map<String, Object> findHomeData();

}
