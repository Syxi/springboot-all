package com.mybatis.service;

import com.mybatis.entity.User;

import java.util.List;

public interface UserService {
    User selectByPrimaryKey(Integer id);
}
