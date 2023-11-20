package com.lin.xxux.service.acl.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lin.xxux.common.service.result.Result;
import com.lin.xxux.model.acl.Role;
import com.lin.xxux.service.acl.service.RoleService;
import com.lin.xxux.vo.acl.RoleQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>TODO</p>
 *
 * @author linsz
 * @version v1.0
 * @date 2023/11/21 00:25
 */
@RestController
@RequestMapping("/admin/acl/role")
@Api(tags = "角色管理模块")
@Slf4j
@CrossOrigin
public class RoleController {


    @Autowired
    private RoleService roleService;

    /**
     * 获取角色分页列表
     */
    @GetMapping("{page}/{limit}")
    @ApiOperation(value = "根据查询条件获取角色分页列表")
    public Result<Page<Role>> getRolePage(RoleQueryVo roleQueryVo,
                                          @PathVariable(value = "page") Long page,
                                          @PathVariable(value = "limit") Long limit) {
        Page<Role> rolePage = roleService.selectPage(roleQueryVo, page, limit);
        return Result.ok(rolePage);
    }


    /**
     * 获取角色
     */
    @ApiOperation(value = "根据id获取角色")
    @GetMapping("get/{id}")
    public Result<Role> getRole(@PathVariable String id) {
        Role role = roleService.getById(id);
        return Result.ok(role);
    }


    @ApiOperation(value = "新增角色")
    @PostMapping("save")
    public Result save(@RequestBody Role role) {
        roleService.save(role);
        return Result.ok();
    }

    @ApiOperation(value = "修改角色")
    @PutMapping("update")
    public Result updateById(@RequestBody Role role) {
        roleService.updateById(role);
        return Result.ok();
    }

    @ApiOperation(value = "删除角色")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        roleService.removeById(id);
        return Result.ok();
    }

    @ApiOperation(value = "根据id列表删除角色")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList) {
        roleService.removeByIds(idList);
        return Result.ok();
    }

}
