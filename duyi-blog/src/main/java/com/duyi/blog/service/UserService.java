package com.duyi.blog.service;

import com.duyi.blog.entity.User;

public interface UserService {


    User login(String name, String password);
}
