package com.lin.xxux.service.acl.service.impl;

import cn.hutool.core.util.ObjUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.xxux.model.acl.Role;
import com.lin.xxux.service.acl.mapper.RoleMapper;
import com.lin.xxux.service.acl.service.RoleService;
import com.lin.xxux.vo.acl.RoleQueryVo;
import org.springframework.stereotype.Service;

/**
* @author linsz
* @description 针对表【role(角色)】的数据库操作Service实现
* @createDate 2023-11-21 00:32:49
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService {

    /**
     * 根据条件分页查询
     *
     * @param roleQueryVo
     * @param page
     * @param limit
     */
    @Override
    public Page<Role> selectPage(RoleQueryVo roleQueryVo, Long page, Long limit) {
        Page<Role> rolePage = new Page<>(page,limit);
        LambdaQueryWrapper<Role> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(ObjUtil.isNotEmpty(roleQueryVo.getRoleName()),Role::getRoleName,roleQueryVo.getRoleName())
                .orderByAsc(Role::getId);
        Page<Role> queryResultPage = this.baseMapper.selectPage(rolePage, wrapper);
        return queryResultPage;
    }
}




