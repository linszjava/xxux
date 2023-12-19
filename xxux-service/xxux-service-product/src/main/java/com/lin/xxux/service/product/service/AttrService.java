package com.lin.xxux.service.product.service;

import com.lin.xxux.model.product.Attr;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author linsz
* @description 针对表【attr(商品属性)】的数据库操作Service
* @createDate 2023-12-11 10:37:41
*/
public interface AttrService extends IService<Attr> {

    //根据属性分组id 获取属性列表
    List<Attr> findByAttrGroupId(Long attrGroupId);
}
