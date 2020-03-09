package com.mall.admin.controller;

import common.api.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin/")
public class UserManagerController {

    @RequestMapping("login")
    public void login() {

        System.out.println(111);
    }
}
