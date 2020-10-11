package com.hsbc.scott.controller;


import com.hsbc.scott.model.User;
import com.hsbc.scott.utils.ResultUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/index")
public class IndexController {


    @GetMapping("/test_get")
    public String testGet(){
        return "Hello World!!!";
    }

    @PostMapping("/test_post")
    @ResponseBody
    public Object testPost(){
        return ResultUtil.success(new User(1, "scott", "hsbc"));
    }
}
