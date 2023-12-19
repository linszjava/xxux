package com.lin.xxux.service.activity.mapper;

import com.lin.xxux.model.activity.ActivityInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lin.xxux.model.activity.ActivityRule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author linsz
* @description 针对表【activity_info(活动表)】的数据库操作Mapper
* @createDate 2023-12-20 02:49:55
* @Entity com.lin.xxux.model.activity.ActivityInfo
*/
public interface ActivityInfoMapper extends BaseMapper<ActivityInfo> {

    List<Long> selectExistSkuIdList(@Param("skuIdList")List<Long> skuIdList);

    List<ActivityRule> selectActivityRuleList(@Param("skuId")Long skuId);

}




