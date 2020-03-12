package com.mall.admin.service;

import com.mall.mbg.pojo.Admin;

import java.util.List;

public interface UserManagerService {

    Admin login(String username, String password);

    Boolean  register(Admin admin);

    Boolean getUserByName(String username);

    Boolean getUserByPhone(String phone);

    /**
     * 根据用户名或昵称分页查询用户
     */
    List<Admin> list(String keyword, Integer pageSize, Integer pageNum);
}
