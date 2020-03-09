package com.mall.admin.controller;

import com.mall.admin.service.UserManagerService;
import com.mall.mbg.pojo.Admin;
import common.api.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin/")
public class UserManagerController {

    @Autowired
    private UserManagerService userManagerService;

    @RequestMapping("login")
    public Result<Object> login(String username, String password) {

        Admin admin = userManagerService.login(username, password);

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
