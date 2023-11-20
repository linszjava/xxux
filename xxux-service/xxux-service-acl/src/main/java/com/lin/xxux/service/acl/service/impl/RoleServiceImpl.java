package com.lin.xxux.service.acl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.xxux.model.acl.Role;
import com.lin.xxux.service.acl.mapper.RoleMapper;
import com.lin.xxux.service.acl.service.RoleService;
import org.springframework.stereotype.Service;

/**
* @author linsz
* @description 针对表【role(角色)】的数据库操作Service实现
* @createDate 2023-11-21 00:32:49
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService {

}




