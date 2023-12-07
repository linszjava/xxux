package com.lin.xxux.service.acl.service;

import com.lin.xxux.model.acl.Permission;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author linsz
* @description 针对表【permission(权限)】的数据库操作Service
* @createDate 2023-12-07 07:40:45
*/
public interface PermissionService extends IService<Permission> {

    /**
     * 获取所有菜单列表
     */
    List<Permission> queryAllMenu();

    /**
     * 递归删除
     */
    boolean removeChildById(Long id);

}
