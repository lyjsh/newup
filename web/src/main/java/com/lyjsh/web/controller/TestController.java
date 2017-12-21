package com.lyjsh.web.controller;

import com.lyjsh.entity.system.User;
import com.lyjsh.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class TestController {

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String test() {
        return "test";
    }

    @ResponseBody
    @RequestMapping("/user/{userName}")
    public User listUser(@PathVariable String userName) {
        return userService.getByUserName(userName);
    }
}
