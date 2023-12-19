package com.lin.xxux.service.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lin.xxux.model.product.SkuInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.xxux.vo.product.SkuInfoQueryVo;
import com.lin.xxux.vo.product.SkuInfoVo;

import java.util.List;

/**
* @author linsz
* @description 针对表【sku_info(sku信息)】的数据库操作Service
* @createDate 2023-12-11 10:37:41
*/
public interface SkuInfoService extends IService<SkuInfo> {

    //获取sku分页列表
    IPage<SkuInfo> selectPage(Page<SkuInfo> pageParam, SkuInfoQueryVo skuInfoQueryVo);

    void saveSkuInfo(SkuInfoVo skuInfoVo);

    //获取商品
    SkuInfoVo getSkuInfoVo(Long id);

    //修改商品
    void updateSkuInfo(SkuInfoVo skuInfoVo);

    //商品审核
    void check(Long skuId, Integer status);

    //商品上架
    void publish(Long skuId, Integer status);

    //新人专享
    void isNewPerson(Long skuId, Integer status);

    //批量获取sku信息
    List<SkuInfo> findSkuInfoList(List<Long> skuIdList);

    //根据关键字获取sku列表
    List<SkuInfo> findSkuInfoByKeyword(String keyword);
}
