package com.lyjsh.web.controller;

import com.lyjsh.entity.system.User;
import com.lyjsh.system.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value="根据用户名获取用户信息", notes="根据url的userName来获取用户详细信息")
    @ApiImplicitParam(name = "userName", value = "用户userName", required = true, dataType = "String")
    @ResponseBody
    @RequestMapping("/user/{userName}")
    public User listUser(@PathVariable String userName) {
        return userService.getByUserName(userName);
    }
}
