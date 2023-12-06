package com.lin.xxux.service.acl.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lin.xxux.common.service.enums.ResultEnum;
import com.lin.xxux.common.service.result.Result;
import com.lin.xxux.common.utils.MD5;
import com.lin.xxux.model.acl.Admin;
import com.lin.xxux.service.acl.service.AdminRoleService;
import com.lin.xxux.service.acl.service.AdminService;
import com.lin.xxux.service.acl.service.RoleService;
import com.lin.xxux.vo.acl.AdminQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>TODO</p>
 *
 * @author linsz
 * @version v1.0
 * @date 2023/12/6 17:17
 */
@RestController
@RequestMapping("/admin/acl/use")
@Api(tags = "用户管理模块")
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminRoleService adminRoleService;

    @ApiOperation(value = "获取管理用户分页列表")
    @GetMapping("{page}/{limit}")
    public Result<IPage<Admin>> getAdminPage(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,
            @ApiParam(name = "adminQueryVo", value = "查询对象", required = false)
            AdminQueryVo adminQueryVo) {

        IPage<Admin> adminIPage = adminService.selectAdminPage(page, limit, adminQueryVo);
        return Result.build(adminIPage, ResultEnum.SUCCESS);
    }

    @ApiOperation(value ="根据id查询用户")
    @GetMapping("get/{id}")
    public Result<Admin> getAdminById(@PathVariable Long id) {
        return Result.ok(adminService.getById(id));
    }

    @ApiOperation(value ="新增用户")
    @PostMapping("save")
    public Result<Admin> saveAdmin(@RequestBody Admin admin) {
        admin.setPassword(MD5.encrypt(admin.getPassword()));
        adminService.save(admin);
        return Result.ok();
    }

    @ApiOperation(value ="修改管理用户")
    @PutMapping("update")
    public Result<Admin> updateAdmin(@RequestBody Admin admin) {
        adminService.updateById(admin);
        return Result.ok();
    }

    @ApiOperation(value ="删除管理用户")
    @DeleteMapping("remove/{id}")
    public Result<Admin> removeAdmin(@PathVariable Long id) {
        adminService.removeById(id);
        return Result.ok();
    }

    @ApiOperation(value ="根据id列表删除管理用户")
    @DeleteMapping("batchRemove")
    public Result<Admin> batchRemoveAdmin(@RequestBody List<Long> ids) {
        adminService.removeByIds(ids);
        return Result.ok();
    }

    @ApiOperation(value = "根据用户获取角色数据")
    @GetMapping("toAssign/{adminId}")
    public Result toAssign(@PathVariable Long adminId) {
        Map<String, Object> rolesByUserId = adminRoleService.findRoleByUserId(adminId);
        return Result.ok(rolesByUserId);
    }






}
