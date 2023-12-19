package com.lin.xxux.service.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lin.xxux.model.user.User;
import com.lin.xxux.service.user.mapper.UserMapper;
import com.lin.xxux.service.user.service.UserService;
import org.springframework.stereotype.Service;

/**
* @author linsz
* @description 针对表【user(会员表)】的数据库操作Service实现
* @createDate 2023-12-31 17:48:20
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

}




