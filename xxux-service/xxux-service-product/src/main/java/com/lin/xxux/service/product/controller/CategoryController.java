package com.lin.xxux.service.product.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lin.xxux.common.service.result.Result;
import com.lin.xxux.model.product.Category;
import com.lin.xxux.service.product.service.CategoryService;
import com.lin.xxux.vo.product.CategoryQueryVo;
import com.lin.xxux.vo.product.CategoryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>TODO</p>
 *
 * @author linsz
 * @version v1.0
 * @date 2023/12/11 10:36
 */
@RestController
@RequestMapping("/admin/product/category")
//@CrossOrigin
@Api(tags = "商品分类管理模块")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ApiOperation("获取商品分类分页列表")
    @GetMapping("{page}/{limit}")
    public Result<IPage<Category>> getCategoryPageList(@ApiParam(name = "page",value = "当前页码",required = true)
                                                       @PathVariable("page") Long page,
                                                       @ApiParam(name = "limit",value = "每页记录数",required = true)
                                                       @PathVariable("limit") Long limit,
                                                       @ApiParam(name = "categoryQueryVo",value = "查询对象",required = false)
                                                       CategoryQueryVo categoryQueryVo){
        IPage<Category> pageModel = categoryService.getCategoryPage(page,limit,categoryQueryVo);
        return Result.ok(pageModel);
    }

    @ApiOperation(value = "获取商品分类信息")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        Category category = categoryService.getById(id);
        return Result.ok(category);
    }

    @ApiOperation(value = "新增商品分类")
    @PostMapping("save")
    public Result save(@RequestBody Category category) {
        categoryService.save(category);
        return Result.ok();
    }

    @ApiOperation(value = "修改商品分类")
    @PutMapping("update")
    public Result updateById(@RequestBody Category category) {
        categoryService.updateById(category);
        return Result.ok();
    }

    @ApiOperation(value = "删除商品分类")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        categoryService.removeById(id);
        return Result.ok();
    }

    @ApiOperation(value = "根据id列表删除商品分类")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList) {
        categoryService.removeByIds(idList);
        return Result.ok();
    }

    @ApiOperation(value = "获取全部商品分类")
    @GetMapping("findAllList")
    public Result findAllList() {
        return Result.ok(categoryService.findAllList());
    }
}
