package com.lin.xxux.service.acl.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.xxux.model.acl.Admin;
import com.lin.xxux.model.acl.AdminRole;
import com.lin.xxux.model.acl.Role;
import com.lin.xxux.service.acl.mapper.AdminMapper;
import com.lin.xxux.service.acl.mapper.AdminRoleMapper;
import com.lin.xxux.service.acl.mapper.RoleMapper;
import com.lin.xxux.service.acl.service.AdminRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
* @author linsz
* @description 针对表【admin_role(用户角色)】的数据库操作Service实现
* @createDate 2023-12-06 21:01:15
*/
@Slf4j
@Service
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole>
    implements AdminRoleService {

    @Autowired
    private RoleMapper roleMapper;


    /**
     * 根据用户id获取角色数据
     * @param adminId
     * @return Map<String, Object> 涵盖  allRoleList(所有角色)  assignedRoleList(已分配角色)
     */
    @Override
    public Map<String, Object> findRoleByUserId(Long adminId) {
        HashMap<String, Object> roleMap = new HashMap<>();

        List<Role> allRoleList = roleMapper.selectList(null);
        // 根据用户id获取该用户在AdminRole表中的所有角色id
        LambdaQueryWrapper<AdminRole> wrapper = new LambdaQueryWrapper<AdminRole>().select(AdminRole::getRoleId)
                .eq(AdminRole::getAdminId, adminId);
        List<AdminRole> adminRoleList = this.list(wrapper);  //得到AdminRole表中的所有角色id
        log.info("adminRoleList:{}",adminRoleList);
        List<Long> roleIdList = adminRoleList.stream().map(AdminRole::getRoleId).collect(Collectors.toList());
        //并且把角色id跟其具体的角色 对应后得到assignRoleList
        List<Role> assignRoleList = new ArrayList<>();
        for (Role role : allRoleList) {
            if (roleIdList.contains(role.getId())) {
                assignRoleList.add(role);
            }
        }
        roleMap.put("assignRoleList",assignRoleList);
        roleMap.put("allRoleList",allRoleList);
        return roleMap;
    }

}




