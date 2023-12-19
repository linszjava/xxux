package com.lin.xxux.service.activity.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.xxux.model.activity.ActivityInfo;
import com.lin.xxux.service.activity.mapper.ActivityInfoMapper;
import com.lin.xxux.service.activity.service.ActivityInfoService;
import org.springframework.stereotype.Service;

/**
* @author linsz
* @description 针对表【activity_info(活动表)】的数据库操作Service实现
* @createDate 2023-12-20 02:49:55
*/
@Service
public class ActivityInfoServiceImpl extends ServiceImpl<ActivityInfoMapper, ActivityInfo>
    implements ActivityInfoService {

}




