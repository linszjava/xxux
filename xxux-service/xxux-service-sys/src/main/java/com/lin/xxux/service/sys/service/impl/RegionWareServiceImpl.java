package com.lin.xxux.service.sys.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.xxux.common.utils.enums.ResultEnum;
import com.lin.xxux.common.utils.exception.CusException;
import com.lin.xxux.model.sys.RegionWare;

import com.lin.xxux.service.sys.mapper.RegionWareMapper;
import com.lin.xxux.service.sys.service.RegionWareService;
import com.lin.xxux.vo.sys.RegionWareQueryVo;
import org.springframework.stereotype.Service;

/**
* @author linsz
* @description 针对表【region_ware(城市仓库关联表)】的数据库操作Service实现
* @createDate 2023-12-07 08:50:03
*/
@Service
public class RegionWareServiceImpl extends ServiceImpl<RegionWareMapper, RegionWare>
    implements RegionWareService {

    /**
     * 分页查询地区仓库
     *
     * @param page
     * @param limit
     * @param regionWareQueryVo
     * @return
     */
    @Override
    public IPage<RegionWare> selectRegionWarePage(Long page, Long limit, RegionWareQueryVo regionWareQueryVo) {
        LambdaQueryWrapper<RegionWare> wrapper = new LambdaQueryWrapper<RegionWare>().like(ObjectUtil.isNotEmpty(regionWareQueryVo.getKeyword()),
                RegionWare::getRegionName, regionWareQueryVo.getKeyword());
        return this.getBaseMapper().selectPage(new Page<>(page, limit), wrapper);
    }

    /**
     * 添加开通区域
     *
     * @param regionWare
     */
    @Override
    public void saveRegionOpened(RegionWare regionWare) {
        LambdaQueryWrapper<RegionWare> wrapper = new LambdaQueryWrapper<RegionWare>().eq(RegionWare::getRegionId, regionWare.getRegionId());
        boolean isOpened = this.count(wrapper) > 0;
        if (isOpened) {
            throw new CusException(ResultEnum.REGION_OPEN);
        }
        this.save(regionWare);
    }

    /**
     * 取消开通区域
     *
     * @param id
     * @param status
     */
    @Override
    public void updateStatus(Long id, Integer status) {
        RegionWare regionWare = this.getById(id);
        if (ObjectUtil.isNull(regionWare)) {
            throw new CusException(ResultEnum.REGION_NO_OPEN);
        }
        regionWare.setStatus(status);
        this.updateById(regionWare);
    }
}




