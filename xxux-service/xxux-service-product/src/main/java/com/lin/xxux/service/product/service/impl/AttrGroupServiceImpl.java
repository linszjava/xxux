package com.lin.xxux.service.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.xxux.model.product.AttrGroup;
import com.lin.xxux.service.product.mapper.AttrGroupMapper;
import com.lin.xxux.service.product.service.AttrGroupService;
import com.lin.xxux.vo.product.AttrGroupQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
* @author linsz
* @description 针对表【attr_group(属性分组)】的数据库操作Service实现
* @createDate 2023-12-11 10:37:41
*/
@Service
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupMapper, AttrGroup>
    implements AttrGroupService {

    //平台属性分组列表
    @Override
    public IPage<AttrGroup> selectPage(Page<AttrGroup> pageParam, AttrGroupQueryVo attrGroupQueryVo) {
        String name = attrGroupQueryVo.getName();
        LambdaQueryWrapper<AttrGroup> wrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(name)) {
            wrapper.like(AttrGroup::getName,name);
        }
        IPage<AttrGroup> attrGroupPage = baseMapper.selectPage(pageParam, wrapper);
        return attrGroupPage;
    }

    //查询所有属性分组
    @Override
    public List<AttrGroup> findAllList() {
        return this.list();
    }
}




