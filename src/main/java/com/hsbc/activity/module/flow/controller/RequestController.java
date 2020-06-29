package com.hsbc.activity.module.flow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/request")
public class RequestController {

    @RequestMapping("/to_do/list")
    public String getMyToDoList(){
        return "request/todo_list";
    }
}
