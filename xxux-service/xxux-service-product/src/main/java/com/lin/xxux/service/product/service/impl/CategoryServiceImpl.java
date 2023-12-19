package com.lin.xxux.service.product.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.xxux.model.product.Category;
import com.lin.xxux.service.product.mapper.CategoryMapper;
import com.lin.xxux.service.product.service.CategoryService;
import com.lin.xxux.vo.product.CategoryQueryVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author linsz
* @description 针对表【category(商品三级分类)】的数据库操作Service实现
* @createDate 2023-12-11 10:37:41
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService {

    /**
     * 分页查询分类列表
     *
     * @param page
     * @param limit
     * @param categoryQueryVo
     * @return
     */
    @Override
    public IPage<Category> getCategoryPage(Long page, Long limit, CategoryQueryVo categoryQueryVo) {
        LambdaQueryWrapper<Category> wrapper = new LambdaQueryWrapper<Category>()
                .like(ObjectUtil.isNotEmpty(categoryQueryVo.getName()), Category::getName, categoryQueryVo.getName())
                .orderByAsc(Category::getSort);
        return this.baseMapper.selectPage(new Page<>(page, limit), wrapper);
    }

    /**
     * 查询所有商品分类
     *
     * @return
     */
    @Override
    public List<Category> findAllList() {
        return this.list(new LambdaQueryWrapper<Category>().orderByAsc(Category::getSort));
    }
}




