package com.duyi.blog.dao;

import com.duyi.blog.entity.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    User findUserByCondition(Map<String, Object> map);

    List<User> findUserAll();

}
