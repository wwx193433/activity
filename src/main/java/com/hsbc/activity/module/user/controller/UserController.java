package com.hsbc.activity.module.user.controller;


import com.hsbc.activity.core.vo.TableVO;
import com.hsbc.activity.module.user.model.User;
import com.hsbc.activity.module.user.service.UserService;
import com.hsbc.activity.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/add")
    public String addUser(){
        User user = new User();
        user.setId(2);
        user.setName("Scott");
        userService.insert(user);
        return "Success";
    }

    @GetMapping("/list")
    @ResponseBody
    public Object queryUserList() {
        List<User> users = new ArrayList<>();
        User u = new User();
        u.setId(1);
        u.setName("Scott");
        u.setAccount("45099624");
        u.setCreateTime("2019-02-12");
        u.setStatus(1);
        users.add(u);
        return ResultUtil.successTable(users);
    }
}
