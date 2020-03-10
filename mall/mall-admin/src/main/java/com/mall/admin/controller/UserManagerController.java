package com.mall.admin.controller;

import com.mall.admin.service.UserManagerService;
import com.mall.common.api.Result;
import com.mall.common.redis.RedisUtil;
import com.mall.mbg.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/admin/")
public class UserManagerController {

    @Autowired
    private UserManagerService userManagerService;

    @Autowired
    public RedisUtil redisUtil;

    @RequestMapping("login")
    public Result<Object> login(HttpSession session, String username, String password) {

        Admin admin = userManagerService.login(username, password);
        redisUtil.set(session.getId(), username);
        redisUtil.get(session.getId());

        return Result.success(admin);
    }

    @RequestMapping("register")
    public Result<Object> register(Admin admin) {
        Boolean flag = userManagerService.register(admin);

        if (flag) {
            return Result.success(null, "创建成功");
        } else {

            return Result.failed("创建失败");
        }
    }

}
