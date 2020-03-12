package com.mall.admin.controller;

import com.mall.admin.service.UserManagerService;
import com.mall.common.api.CommonPage;
import com.mall.common.api.Result;
import com.mall.common.redis.RedisUtil;
import com.mall.mbg.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/admin/")
public class UserManagerController {

    @Autowired
    private UserManagerService userManagerService;

    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("login")
    public Result<Admin> login(HttpSession session, String username, String password) {

        Admin admin = userManagerService.login(username, password);
        if (null != admin) {

            redisUtil.set(session.getId(), username);

            return Result.success(admin);
        } else {

            return Result.failed("账号或者密码错误");
        }

    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public Result<Object> logout(HttpSession httpSession) {
        redisUtil.del(httpSession.getId());
        return Result.success(null);
    }

    @RequestMapping(value = "username", method = RequestMethod.GET)
    public boolean getUserByName(String username) {

        return userManagerService.getUserByName(username);
    }

    @RequestMapping(value = "phone", method = RequestMethod.GET)
    public boolean getUserByEmail(String phone) {

        return userManagerService.getUserByPhone(phone);
    }

    @RequestMapping("register")
    public Result<Admin> register(Admin admin) {
        Boolean flag = userManagerService.register(admin);

        if (flag) {
            return Result.success(null, "注册成功");
        } else {

            return Result.failed("注册失败");
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Result<CommonPage<Admin>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                          @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<Admin> adminList = userManagerService.list(keyword, pageSize, pageNum);
        return Result.success(CommonPage.restPage(adminList));
    }

}
