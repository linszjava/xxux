package com.lin.xxux.service.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.xxux.model.sys.RegionWare;

import com.lin.xxux.service.sys.mapper.RegionWareMapper;
import com.lin.xxux.service.sys.service.RegionWareService;
import org.springframework.stereotype.Service;

/**
* @author linsz
* @description 针对表【region_ware(城市仓库关联表)】的数据库操作Service实现
* @createDate 2023-12-07 08:50:03
*/
@Service
public class RegionWareServiceImpl extends ServiceImpl<RegionWareMapper, RegionWare>
    implements RegionWareService {

}




