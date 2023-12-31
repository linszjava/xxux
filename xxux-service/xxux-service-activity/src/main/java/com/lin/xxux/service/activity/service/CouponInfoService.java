package com.lin.xxux.service.activity.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lin.xxux.model.activity.CouponInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.xxux.vo.activity.CouponRuleVo;

import java.util.List;
import java.util.Map;

/**
* @author linsz
* @description 针对表【coupon_info(优惠券信息)】的数据库操作Service
* @createDate 2023-12-20 02:49:55
*/
public interface CouponInfoService extends IService<CouponInfo> {


    //优惠卷分页查询
    IPage<CouponInfo> selectPage(Page<CouponInfo> pageParam);

    //根据id获取优惠券
    CouponInfo getCouponInfo(String id);

    //根据优惠卷id获取优惠券规则列表
    Map<String, Object> findCouponRuleList(Long couponId);

    //新增优惠券规则
    void saveCouponRule(CouponRuleVo couponRuleVo);

    //根据关键字获取sku列表，活动使用
    List<CouponInfo> findCouponByKeyword(String keyword);

}
