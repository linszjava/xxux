package com.lin.xxux.service.acl.controller;

import com.lin.xxux.service.acl.service.RoleService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>TODO</p>
 *
 * @author linsz
 * @version v1.0
 * @date 2023/11/21 00:25
 */
@RestController
@RequestMapping("/admin/acl/role")
@Api(tags = "角色管理")
@Slf4j
public class RoleController {


    @Autowired
    private RoleService roleService;

    /**
     * 获取角色分页列表
     */


    /**
     * 获取角色
     */

    /**
     * 新增角色
     */

    /**
     * 修改角色
     */

    /**
     * 删除角色
     */

    /**
     * 根据id列表删除角色
     */

}
