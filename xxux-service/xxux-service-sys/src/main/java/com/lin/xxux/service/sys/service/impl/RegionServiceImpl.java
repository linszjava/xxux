package com.lin.xxux.service.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.xxux.model.sys.Region;

import com.lin.xxux.service.sys.mapper.RegionMapper;
import com.lin.xxux.service.sys.service.RegionService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author linsz
* @description 针对表【region(地区表)】的数据库操作Service实现
* @createDate 2023-12-07 08:50:03
*/
@Service
public class RegionServiceImpl extends ServiceImpl<RegionMapper, Region>
    implements RegionService {

    /**
     * 根据关键字获取地区列表
     *
     * @param keyword
     * @return
     */
    @Override
    public List<Region> findResionByKeyword(String keyword) {
        LambdaQueryWrapper<Region> wrapper = new LambdaQueryWrapper<Region>().like(Region::getName, keyword);
        return this.list(wrapper);
    }
}




