package com.mall.common.mongo.service;

import com.mall.common.mongo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hc
 * @classname UserServiceImpl
 * @description TODO
 * @date 2020/3/4
 */
@Service
public class MongoDbService {

    @Autowired
    private MongoTemplate mongoTemplate = null;

    /**
     * 保存对象
     * @param user
     * @return
     */
    public String saveObj(User user) {
        mongoTemplate.save(user);
        return "添加成功";
    }

    /**
     * 查询所有
     * @return
     */
    public List<User> findAll() {
        return mongoTemplate.findAll(User.class);
    }

    /***
     * 根据id查询
     * @param id
     * @return
     */
    public User getBookById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        return mongoTemplate.findOne(query, User.class);
    }

    }


