package com.lin.xxux.service.sys.service;

import com.lin.xxux.model.sys.Region;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author linsz
* @description 针对表【region(地区表)】的数据库操作Service
* @createDate 2023-12-07 08:50:03
*/
public interface RegionService extends IService<Region> {

    /**
     * 根据关键字获取地区列表
     * @param keyword
     * @return
     */
    List<Region> findResionByKeyword(String keyword);
}
