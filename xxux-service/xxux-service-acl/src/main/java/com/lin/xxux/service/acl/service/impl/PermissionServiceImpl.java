package com.lin.xxux.service.acl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.xxux.common.utils.tree.PermissionUtil;
import com.lin.xxux.model.acl.Permission;

import com.lin.xxux.service.acl.mapper.PermissionMapper;
import com.lin.xxux.service.acl.service.PermissionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author linsz
* @description 针对表【permission(权限)】的数据库操作Service实现
* @createDate 2023-12-07 07:40:45
*/
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission>
    implements PermissionService {

    /**
     * 获取所有菜单列表
     */
    @Override
    public List<Permission> queryAllMenu() {
        // 获取全部的权限数据
        List<Permission> allPermissionList = this.list(new LambdaQueryWrapper<Permission>().orderByAsc(Permission::getId));
        // 将数据转换成树形结构
        return PermissionUtil.build(allPermissionList);
    }

    /**
     * 递归删除
     *
     * @param id
     */
    @Override
    public boolean removeChildById(Long id) {
        List<Long> idList = new ArrayList<>();
        this.selectChildListById(id,idList);
        idList.add(id);
        this.removeByIds(idList);
        return true;
    }

    /**
     * 递归获取子节点
     */
    private void selectChildListById(Long id ,List<Long> idList) {
        this.list(new LambdaQueryWrapper<Permission>().eq(Permission::getPid,id).select(Permission::getId)).forEach(item -> {
            idList.add(item.getId());
            this.selectChildListById(item.getId(),idList);
        });
    }
}




