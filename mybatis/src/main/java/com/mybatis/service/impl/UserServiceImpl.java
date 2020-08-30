package com.mybatis.service.impl;

import com.mybatis.entity.User;
import com.mybatis.mapper.UserMapper;
import com.mybatis.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author suYan
 * @Date 2020/5/10 0:42
 */

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
