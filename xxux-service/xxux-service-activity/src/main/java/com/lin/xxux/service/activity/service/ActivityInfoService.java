package com.lin.xxux.service.activity.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lin.xxux.model.activity.ActivityInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.xxux.model.activity.ActivityRule;
import com.lin.xxux.model.product.SkuInfo;
import com.lin.xxux.vo.activity.ActivityRuleVo;

import java.util.List;
import java.util.Map;

/**
* @author linsz
* @description 针对表【activity_info(活动表)】的数据库操作Service
* @createDate 2023-12-20 02:49:55
*/
public interface ActivityInfoService extends IService<ActivityInfo> {

    /**
     * 分页查询
     * @param pageParam
     * @return
     */
    IPage<ActivityInfo> selectPage(Page<ActivityInfo> pageParam);

    /**
     * 获取活动规则id
     * @param activityId
     * @return
     */
    Map<String, Object> findActivityRuleList(Long activityId);

    //保存活动规则信息
    void saveActivityRule(ActivityRuleVo activityRuleVo);

    //根据关键字获取sku信息列表
    List<SkuInfo> findSkuInfoByKeyword(String keyword);

    /**
     * 根据skuId获取促销规则信息
     * @param skuId
     * @return
     */
    List<ActivityRule> findActivityRule(Long skuId);

}
