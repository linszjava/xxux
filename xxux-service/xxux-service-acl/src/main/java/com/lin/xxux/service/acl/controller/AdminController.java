package com.lin.xxux.service.acl.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lin.xxux.common.service.enums.ResultEnum;
import com.lin.xxux.common.service.result.Result;
import com.lin.xxux.model.acl.Admin;
import com.lin.xxux.service.acl.service.AdminService;
import com.lin.xxux.service.acl.service.RoleService;
import com.lin.xxux.vo.acl.AdminQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private RoleService roleService;

    @ApiOperation(value = "获取管理用户分页列表")
    @GetMapping("{page}/{limit}")
    public Result getAdminPage(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,
            @ApiParam(name = "adminQueryVo", value = "查询对象", required = false)
            AdminQueryVo adminQueryVo) {

        IPage<Admin> adminIPage = adminService.selectAdminPage(page, limit, adminQueryVo);
        return Result.build(adminIPage, ResultEnum.SUCCESS);
    }


}
