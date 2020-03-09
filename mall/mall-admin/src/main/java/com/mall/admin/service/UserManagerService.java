package com.mall.admin.service;

import com.mall.mbg.pojo.Admin;

public interface UserManagerService {

    Admin login(String username, String password);

    Boolean  register(Admin admin);
}
