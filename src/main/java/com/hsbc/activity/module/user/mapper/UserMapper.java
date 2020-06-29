package com.hsbc.activity.module.user.mapper;

import com.hsbc.activity.module.user.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int insert(User record);

}