package com.lin.xxux.service.activity.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.xxux.enums.ActivityType;
import com.lin.xxux.model.activity.ActivityInfo;
import com.lin.xxux.model.activity.ActivityRule;
import com.lin.xxux.model.activity.ActivitySku;
import com.lin.xxux.model.product.SkuInfo;
import com.lin.xxux.service.activity.mapper.ActivityInfoMapper;
import com.lin.xxux.service.activity.mapper.ActivityRuleMapper;
import com.lin.xxux.service.activity.mapper.ActivitySkuMapper;
import com.lin.xxux.service.activity.service.ActivityInfoService;
import com.lin.xxux.service.client.ProductFeignClientService;
import com.lin.xxux.vo.activity.ActivityRuleVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ActivityInfoServiceImpl extends ServiceImpl<ActivityInfoMapper, ActivityInfo> implements ActivityInfoService {

    @Autowired
    private ActivityInfoMapper activityInfoMapper;

    @Autowired
    private ActivityRuleMapper activityRuleMapper;

    @Autowired
    private ActivitySkuMapper activitySkuMapper;

    @Autowired
    private ProductFeignClientService productFeignClient;

    //优惠活动列表方法
    @Override
    public IPage<ActivityInfo> selectPage(Page<ActivityInfo> pageParam) {
        LambdaQueryWrapper<ActivityInfo> wrapper = new LambdaQueryWrapper<ActivityInfo>().orderByAsc(ActivityInfo::getId);
        IPage<ActivityInfo> page = activityInfoMapper.selectPage(pageParam, wrapper);
        page.getRecords().forEach(item -> item.setActivityTypeString(item.getActivityType().getComment()));
        return page;
    }

    //活动规则列表方法
    @Override
    public Map<String, Object> findActivityRuleList(Long activityId) {
        Map<String, Object> result = new HashMap<>();

        QueryWrapper queryWrapper = new QueryWrapper<ActivityRule>();
        queryWrapper.eq("activity_id",activityId);
        List<ActivityRule> activityRuleList = activityRuleMapper.selectList(queryWrapper);
        result.put("activityRuleList", activityRuleList);

        QueryWrapper activitySkuQueryWrapper = new QueryWrapper<ActivitySku>();
        activitySkuQueryWrapper.eq("activity_id",activityId);
        List<ActivitySku> activitySkuList = activitySkuMapper.selectList(activitySkuQueryWrapper);
        List<Long> skuIdList = activitySkuList.stream().map(ActivitySku::getSkuId).collect(Collectors.toList());
        List<SkuInfo> skuInfoList = productFeignClient.findSkuInfoList(skuIdList);
        result.put("skuInfoList", skuInfoList);
        return result;
    }

    //保存活动规则
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveActivityRule(ActivityRuleVo activityRuleVo) {
        activityRuleMapper.delete(new QueryWrapper<ActivityRule>().eq("activity_id",activityRuleVo.getActivityId()));
        activitySkuMapper.delete(new QueryWrapper<ActivitySku>().eq("activity_id",activityRuleVo.getActivityId()));

        List<ActivityRule> activityRuleList = activityRuleVo.getActivityRuleList();
        List<ActivitySku> activitySkuList = activityRuleVo.getActivitySkuList();
        List<Long> couponIdList = activityRuleVo.getCouponIdList();

        ActivityInfo activityInfo = activityInfoMapper.selectById(activityRuleVo.getActivityId());
        for(ActivityRule activityRule : activityRuleList) {
            activityRule.setActivityId(activityRuleVo.getActivityId());
            activityRule.setActivityType(activityInfo.getActivityType());
            activityRuleMapper.insert(activityRule);
        }

        for(ActivitySku activitySku : activitySkuList) {
            activitySku.setActivityId(activityRuleVo.getActivityId());
            activitySkuMapper.insert(activitySku);
        }
    }

    //根据关键字查询sku信息列表
    @Override
    public List<SkuInfo> findSkuInfoByKeyword(String keyword) {
        List<SkuInfo> skuInfoList = productFeignClient.findSkuInfoByKeyword(keyword);
        List<Long> skuIdList = skuInfoList.stream().map(SkuInfo::getId).collect(Collectors.toList());

        List<SkuInfo> notExistSkuInfoList = new ArrayList<>();
        //已经存在的skuId，一个sku只能参加一个促销活动，所以存在的得排除
        List<Long> existSkuIdList = activityInfoMapper.selectExistSkuIdList(skuIdList);
        String existSkuIdString = "," + StringUtils.join(existSkuIdList.toArray(), ",") + ",";
        for(SkuInfo skuInfo : skuInfoList) {
            if(existSkuIdString.indexOf(","+skuInfo.getId()+",") == -1) {
                notExistSkuInfoList.add(skuInfo);
            }
        }
        return notExistSkuInfoList;
    }

    //查询商品获取规则数据
    @Override
    public List<ActivityRule> findActivityRule(Long skuId) {
        List<ActivityRule> activityRuleList = activityInfoMapper.selectActivityRuleList(skuId);
        if(!CollectionUtils.isEmpty(activityRuleList)) {
            for(ActivityRule activityRule : activityRuleList) {
                activityRule.setRuleDesc(this.getRuleDesc(activityRule));
            }
        }
        return activityRuleList;
    }

    private String getRuleDesc(ActivityRule activityRule) {
        ActivityType activityType = activityRule.getActivityType();
        StringBuffer ruleDesc = new StringBuffer();
        if (activityType == ActivityType.FULL_REDUCTION) {
            ruleDesc
                    .append("满")
                    .append(activityRule.getConditionAmount())
                    .append("元减")
                    .append(activityRule.getBenefitAmount())
                    .append("元");
        } else {
            ruleDesc
                    .append("满")
                    .append(activityRule.getConditionNum())
                    .append("元打")
                    .append(activityRule.getBenefitDiscount())
                    .append("折");
        }
        return ruleDesc.toString();
    }
}