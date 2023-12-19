package com.lin.xxux.service.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lin.xxux.model.product.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.xxux.vo.product.CategoryQueryVo;
import com.lin.xxux.vo.product.CategoryVo;

import java.util.List;

/**
* @author linsz
* @description 针对表【category(商品三级分类)】的数据库操作Service
* @createDate 2023-12-11 10:37:41
*/
public interface CategoryService extends IService<Category> {

    /**
     * 分页查询分类列表
     * @param page
     * @param limit
     * @param categoryQueryVo
     * @return
     */
    IPage<Category> getCategoryPage(Long page, Long limit, CategoryQueryVo categoryQueryVo);

    /**
     * 查询所有商品分类
     * @return
     */
    List<Category> findAllList();
}
