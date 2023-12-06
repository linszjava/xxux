package com.lin.xxux.service.acl.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.xxux.model.acl.Role;
import com.lin.xxux.vo.acl.RoleQueryVo;

import java.util.Map;

/**
* @author linsz
* @description 针对表【role(角色)】的数据库操作Service
* @createDate 2023-11-21 00:32:49
*/
public interface RoleService extends IService<Role> {

    /**
     * 根据条件分页查询
     * @param roleQueryVo
     * @param page
     * @param limit
     */
    Page<Role> selectPage(RoleQueryVo roleQueryVo, Long page, Long limit);


}
