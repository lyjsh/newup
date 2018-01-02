package com.lyjsh.web.controller;

import com.lyjsh.entity.system.User;
import com.lyjsh.system.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ModelAndView login(ModelAndView mv,String userName,String pwd) {
        UsernamePasswordToken token = new UsernamePasswordToken(userName, pwd);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (IncorrectCredentialsException ice) {
            // 捕获密码错误异常
            mv.setViewName("error");
            mv.addObject("message", "password error!");
            return mv;
        } catch (UnknownAccountException uae) {
            // 捕获未知用户名异常
            mv.setViewName("error");
            mv.addObject("message", "username error!");
            return mv;
        } catch (ExcessiveAttemptsException eae) {
            // 捕获错误登录过多的异常
            mv.setViewName("error");
            mv.addObject("message", "times error");
            return mv;
        }
        User user = userService.getByUserName(userName);
        subject.getSession().setAttribute("user", user);
        return new ModelAndView("success");
    }

    @RequestMapping("/")
    public ModelAndView toIndexView(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping("/toMain")
    public String toLoginView() {
        return "/system/org/main";
    }
}
