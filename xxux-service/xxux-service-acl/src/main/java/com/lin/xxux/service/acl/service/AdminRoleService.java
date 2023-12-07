package com.lin.xxux.service.acl.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.xxux.model.acl.AdminRole;

import java.util.Map;

/**
* @author linsz
* @description 针对表【admin_role(用户角色)】的数据库操作Service
* @createDate 2023-12-06 21:01:15
*/
public interface AdminRoleService extends IService<AdminRole> {

    /**
     * 根据用户id获取角色数据
     * @param adminId
     * @return
     */
    Map<String, Object> findRoleByUserId(Long adminId);

    void saveAdminRole(Long adminId, Long[] roleIds);
}
