package com.mall.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.mall.admin.service.UserManagerService;
import com.mall.common.constants.Constants;
import com.mall.mbg.mapper.AdminMapper;
import com.mall.mbg.pojo.Admin;
import com.mall.mbg.pojo.AdminExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
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

    private static AdminExample adminExample = new AdminExample();

    @Override
    public List<Admin> list(String keyword, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        AdminExample.Criteria criteria = adminExample.createCriteria();
        if (!StringUtils.isEmpty(keyword)) {
            criteria.andUsernameLike("%" + keyword + "%");
            adminExample.or(adminExample.createCriteria().andNickNameLike("%" + keyword + "%"));
        }
        return adminMapper.selectByExample(adminExample);
    }

    @Override
    public Boolean getUserByPhone(String phone) {

        adminExample.createCriteria().andPhoneEqualTo(phone);
        List<Admin> list = adminMapper.selectByExample(adminExample);
        return list.size() > 0 ? true : false;
    }

    @Override
    public Boolean getUserByName(String username) {

        adminExample.createCriteria().andUsernameEqualTo(username);
        List<Admin> list = adminMapper.selectByExample(adminExample);
        return list.size() > 0 ? true : false;

    }

    @Override
    public Boolean register(Admin admin) {

        Boolean flag = true;
        admin.setStatus(1);
        admin.setCreateTime(new Date());
        admin.setRole(Constants.Role.GENERAL_MANAGER);
        Integer result = adminMapper.insert(admin);
        if (result <= 0) {
            return false;
        }

        return flag;
    }

    @Override
    public Admin login(String username, String password) {

        adminExample.createCriteria().andIdIsNotNull();

        List<Admin> list = adminMapper.selectByExample(adminExample);

        return list.size() > 0 ? list.get(0) : null;
    }
}
