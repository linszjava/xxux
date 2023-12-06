package com.lin.xxux.service.acl.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lin.xxux.model.acl.Admin;
import com.lin.xxux.vo.acl.AdminQueryVo;

/**
* @author linsz
* @description 针对表【admin(用户表)】的数据库操作Service
* @createDate 2023-12-06 17:17:35
*/
public interface AdminService extends IService<Admin> {

    /**
     * 获取管理用户分页列表
     */
    IPage<Admin> selectAdminPage(Long page, Long limit, AdminQueryVo adminQueryVo);

}
