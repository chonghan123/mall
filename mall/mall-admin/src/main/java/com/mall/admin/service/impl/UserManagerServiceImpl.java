package com.mall.admin.service.impl;

import com.mall.admin.service.UserManagerService;
import com.mall.mbg.mapper.AdminMapper;
import com.mall.mbg.pojo.Admin;
import com.mall.mbg.pojo.AdminExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hc
 * @classname UserManagerServiceImpl
 * @description TODO
 * @date 2020/3/9
 */
@Service
public class UserManagerServiceImpl implements UserManagerService {

    @Autowired
    private AdminMapper adminMapper;


    @Override
    public Boolean register(Admin admin) {

     Boolean flag = true;
     Integer result = adminMapper.insert(admin);
     if (result<=0) {
         return false;
     }
     return  flag;
    }

    @Override
    public Admin login(String username, String password) {

        AdminExample adminExample = new AdminExample();

        adminExample.createCriteria().andIdIsNotNull();

        List<Admin> list = adminMapper.selectByExample(adminExample);


        return list.get(0);
    }
}
