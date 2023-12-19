package com.lin.xxux.service.acl.controller;

import cn.hutool.core.lang.hash.Hash;
import cn.hutool.core.util.RandomUtil;
import com.lin.xxux.common.service.result.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>TODO</p>
 *
 * @author linsz
 * @version v1.0
 * @date 2023/11/21 01:02
 */
@RestController
@RequestMapping("/admin/acl/index")
@Api(tags = "用户登录模块")
//@CrossOrigin
public class IndexController {


    /**
     * 请求登录login
     */
    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public Result<Map<String,String>> login() {
        Map<String, String> map = new HashMap<>();
        map.put("token", "admin-token");
        return Result.ok(map);
    }

    /**
     * 获取用户信息
     */
    @ApiOperation(value = "获取用户信息")
    @GetMapping("/info")
    public Result<Map<String,Object>> getInfo() {
        Map<String, Object> map = new HashMap<>();
        map.put("name","linsz");
        map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        return Result.ok(map);
    }

    /**
     * 退出登录
     */
    @ApiOperation(value = "退出登录")
    @GetMapping("/logout")
    public Result logout() {
        return Result.ok();
    }


}
