package com.lin.xxux.service.activity.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lin.xxux.model.activity.Seckill;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.xxux.vo.activity.SeckillQueryVo;

/**
* @author linsz
* @description 针对表【seckill(秒杀活动)】的数据库操作Service
* @createDate 2023-12-26 09:21:05
*/
public interface SeckillService extends IService<Seckill> {

    IPage<Seckill> selectPage(Page<Seckill> pageParam, SeckillQueryVo seckillQueryVo);

    void updateStatus(Long id, Integer status);

}
