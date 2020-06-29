package com.hsbc.activity.module.user.service;

import com.hsbc.activity.module.user.model.User;
import com.hsbc.activity.module.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }
}
