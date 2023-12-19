package com.lin.xxux.service.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.xxux.model.activity.Seckill;
import com.lin.xxux.service.activity.mapper.SeckillMapper;
import com.lin.xxux.service.activity.service.SeckillService;
import com.lin.xxux.vo.activity.SeckillQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
* @author linsz
* @description 针对表【seckill(秒杀活动)】的数据库操作Service实现
* @createDate 2023-12-26 09:21:05
*/
@Service
public class SeckillServiceImpl extends ServiceImpl<SeckillMapper, Seckill>
    implements SeckillService {

    @Resource
    private SeckillMapper seckillMapper;

    @Override
    public IPage<Seckill> selectPage(Page<Seckill> pageParam, SeckillQueryVo seckillQueryVo) {
        Integer status = seckillQueryVo.getStatus();
        String title = seckillQueryVo.getTitle();
        LambdaQueryWrapper<Seckill> wrapper = new LambdaQueryWrapper<>();
        if(!StringUtils.isEmpty(status)) {
            wrapper.eq(Seckill::getStatus,status);
        }
        if(!StringUtils.isEmpty(title)) {
            wrapper.like(Seckill::getTitle,title);
        }
        IPage<Seckill> seckillPage = baseMapper.selectPage(pageParam, wrapper);
        return seckillPage;
    }

    @Override
    public void updateStatus(Long id, Integer status) {
        Seckill seckill = new Seckill();
        seckill.setStatus(status);
        seckill.setId(id);
        this.updateById(seckill);
    }

}




