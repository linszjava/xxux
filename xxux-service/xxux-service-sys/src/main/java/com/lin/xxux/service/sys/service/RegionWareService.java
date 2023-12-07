package com.lin.xxux.service.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lin.xxux.model.sys.RegionWare;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.xxux.vo.sys.RegionWareQueryVo;

import java.util.List;

/**
* @author linsz
* @description 针对表【region_ware(城市仓库关联表)】的数据库操作Service
* @createDate 2023-12-07 08:50:03
*/
public interface RegionWareService extends IService<RegionWare> {

    /**
     * 分页查询地区仓库
     * @param page
     * @param limit
     * @param regionWareQueryVo
     * @return
     */
    IPage<RegionWare> selectRegionWarePage(Long page, Long limit, RegionWareQueryVo regionWareQueryVo);

    /**
     * 添加开通区域
     * @param regionWare
     */
    void saveRegionOpened(RegionWare regionWare);

    /**
     * 取消开通区域
     * @param id
     */
    void updateStatus(Long id, Integer status);
}
