package com.lin.xxux.service.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.xxux.model.product.Attr;
import com.lin.xxux.service.product.mapper.AttrMapper;
import com.lin.xxux.service.product.service.AttrService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author linsz
* @description 针对表【attr(商品属性)】的数据库操作Service实现
* @createDate 2023-12-11 10:37:41
*/
@Service
public class AttrServiceImpl extends ServiceImpl<AttrMapper, Attr>
    implements AttrService {

    //根据属性分组id 获取属性列表
    @Override
    public List<Attr> findByAttrGroupId(Long attrGroupId) {
        LambdaQueryWrapper<Attr> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Attr::getAttrGroupId, attrGroupId);
        List<Attr> attrList = baseMapper.selectList(wrapper);
        return attrList;
    }
}




