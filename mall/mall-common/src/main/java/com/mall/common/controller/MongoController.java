package com.mall.common.controller;

import com.mall.common.mongo.repository.UserRepository;
import com.mall.common.mongo.service.MongoDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hc
 * @classname MongoController
 * @description 两种方式实现
 * @date 2020/3/11
 */
@Controller
@RequestMapping
public class MongoController {

    @Autowired
    private MongoDbService mongoDbService;

    @Autowired
    private UserRepository userRepository;

}
