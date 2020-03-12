package com.mall.common.mongo.repository;

import com.mall.common.mongo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author hc
 * @classname UserRepository
 * @description TODO
 * @date 2020/3/4
 */
@Repository
public interface UserRepository extends MongoRepository<User, Integer> {
}
