package com.lin.xxux.service.acl.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.lin.xxux.model.acl.Admin;
import com.lin.xxux.service.acl.mapper.AdminMapper;
import com.lin.xxux.service.acl.service.AdminService;
import com.lin.xxux.vo.acl.AdminQueryVo;
import org.springframework.stereotype.Service;

/**
* @author linsz
* @description 针对表【admin(用户表)】的数据库操作Service实现
* @createDate 2023-12-06 17:17:35
*/
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin>
    implements AdminService {

    /**
     * 获取管理用户分页列表
     *
     * @param page
     * @param limit
     * @param adminQueryVo
     */
    @Override
    public IPage<Admin> selectAdminPage(Long page, Long limit, AdminQueryVo adminQueryVo) {
        LambdaQueryWrapper<Admin> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(ObjectUtil.isNotEmpty(adminQueryVo.getName()), Admin::getName, adminQueryVo.getName())
                .orderByDesc(Admin::getCreateTime);

        return baseMapper.selectPage(new Page<>(page, limit), wrapper);
    }
}




