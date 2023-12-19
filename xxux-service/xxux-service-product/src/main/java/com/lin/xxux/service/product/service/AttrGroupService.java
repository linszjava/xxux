package com.lin.xxux.service.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lin.xxux.model.product.AttrGroup;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.xxux.vo.product.AttrGroupQueryVo;

import java.util.List;

/**
* @author linsz
* @description 针对表【attr_group(属性分组)】的数据库操作Service
* @createDate 2023-12-11 10:37:41
*/
public interface AttrGroupService extends IService<AttrGroup> {

    //平台属性分组列表
    IPage<AttrGroup> selectPage(Page<AttrGroup> pageParam, AttrGroupQueryVo attrGroupQueryVo);

    //查询所有属性分组
    List<AttrGroup> findAllList();

}
