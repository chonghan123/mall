package com.mall.common.mongo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author hc
 * @classname User
 * @description TODO
 * @date 2020/3/11
 */
@Document(collection = "user")
public class User {

    @Id
    private String id;
    @Field("name")
    private String name;

}
