package com.lin.xxux.service.activity.controller;

import com.lin.xxux.common.service.result.Result;
import com.lin.xxux.model.activity.SeckillTime;
import com.lin.xxux.service.activity.service.SeckillTimeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>TODO</p>
 *
 * @author linsz
 * @version v1.0
 * @date 2023/12/26 09:19
 */
@Api(value = "秒杀场次管理", tags = "秒杀场次管理")
@RestController
@RequestMapping(value="/admin/activity/seckillTime")
@SuppressWarnings({"unchecked", "rawtypes"})
public class SecKillTimeController {

    @Resource
    private SeckillTimeService seckillTimeService;

    @ApiOperation(value = "获取分页列表")
    @GetMapping()
    public Result index() {
        return Result.ok(seckillTimeService.list());
    }

    @ApiOperation(value = "获取")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        SeckillTime seckillSession = seckillTimeService.getById(id);
        return Result.ok(seckillSession);
    }

    @ApiOperation(value = "新增")
    @PostMapping("save")
    public Result save(@RequestBody SeckillTime seckillSession) {
        seckillTimeService.save(seckillSession);
        return Result.ok();
    }

    @ApiOperation(value = "修改")
    @PutMapping("update")
    public Result updateById(@RequestBody SeckillTime seckillSession) {
        seckillTimeService.updateById(seckillSession);
        return Result.ok();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        seckillTimeService.removeById(id);
        return Result.ok();
    }

    @ApiOperation(value = "根据id列表删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList) {
        seckillTimeService.removeByIds(idList);
        return Result.ok();
    }

    @ApiOperation(value = "更新状态")
    @PostMapping("updateStatus/{id}/{status}")
    public Result updateStatus(@PathVariable Long id, @PathVariable Integer status) {
        seckillTimeService.updateStatus(id, status);
        return Result.ok();
    }
}