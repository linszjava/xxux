package com.lin.xxux.service.activity.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lin.xxux.common.service.result.Result;
import com.lin.xxux.model.activity.ActivityInfo;
import com.lin.xxux.service.activity.service.ActivityInfoService;
import com.lin.xxux.vo.activity.ActivityRuleVo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * <p>TODO</p>
 *
 * @author linsz
 * @version v1.0
 * @date 2023/12/20 04:34
 */
@RestController
@RequestMapping("/admin/activity/activityInfo")
//@CrossOrigin
public class ActivityInfoController {

    @Autowired
    private ActivityInfoService activityInfoService;

    @ApiOperation(value = "获取分页列表")
    @GetMapping("{page}/{limit}")
    public Result index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,

            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit) {
        Page<ActivityInfo> pageParam = new Page<>(page, limit);
        IPage<ActivityInfo> pageModel = activityInfoService.selectPage(pageParam);
        return Result.ok(pageModel);
    }

    @ApiOperation(value = "获取活动")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        ActivityInfo activityInfo = activityInfoService.getById(id);
        activityInfo.setActivityTypeString(activityInfo.getActivityType().getComment());
        return Result.ok(activityInfo);
    }

    @ApiOperation(value = "新增活动")
    @PostMapping("save")
    public Result save(@RequestBody ActivityInfo activityInfo) {
        activityInfo.setCreateTime(new Date());
        activityInfoService.save(activityInfo);
        return Result.ok();
    }

    @ApiOperation(value = "修改活动")
    @PutMapping("update")
    public Result updateById(@RequestBody ActivityInfo activityInfo) {
        activityInfoService.updateById(activityInfo);
        return Result.ok();
    }

    @ApiOperation(value = "删除活动")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        activityInfoService.removeById(id);
        return Result.ok();
    }

    @ApiOperation(value="根据id列表删除活动")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<String> idList){
        activityInfoService.removeByIds(idList);
        return Result.ok();
    }

    @ApiOperation(value = "获取活动规则")
    @GetMapping("findActivityRuleList/{id}")
    public Result findActivityRuleList(@PathVariable Long id) {
        return Result.ok(activityInfoService.findActivityRuleList(id));
    }

    @ApiOperation(value = "新增活动规则")
    @PostMapping("saveActivityRule")
    public Result saveActivityRule(@RequestBody ActivityRuleVo activityRuleVo) {
        activityInfoService.saveActivityRule(activityRuleVo);
        return Result.ok();
    }

    /**
     * 根据关键字获取sku列表，活动使用
     * @param keyword
     * @return
     */
    @GetMapping("findSkuInfoByKeyword/{keyword}")
    public Result findSkuInfoByKeyword(@PathVariable("keyword") String keyword) {
        return Result.ok(activityInfoService.findSkuInfoByKeyword(keyword));
    }


}
