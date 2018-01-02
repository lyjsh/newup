package com.lyjsh.web.controller;

import com.lyjsh.entity.system.User;
import com.lyjsh.system.service.UserService;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping
@Controller
public class LoginController {

    private static final Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ModelAndView login(ModelAndView mv) {
        mv.setViewName("/login");
        return mv;
    }

    @RequestMapping("/index")
    public ModelAndView toMainView(ModelAndView modelAndView) {
        modelAndView.addObject("view","/system/main.ftl");
        modelAndView.setViewName("system/layout");
        return modelAndView;
    }

    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String login(User user, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if(bindingResult.hasErrors()){
            return "redirect:login";
        }
        //验证
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPwd());
        //获取当前的Subject
        Subject currentUser = SecurityUtils.getSubject();
        try {
            //在调用了login方法后,SecurityManager会收到AuthenticationToken,并将其发送给已配置的Realm执行必须的认证检查
            //每个Realm都能在必要时对提交的AuthenticationTokens作出反应
            //所以这一步在调用login(token)方法时,它会走到MyRealm.doGetAuthenticationInfo()方法中,具体验证方式详见此方法
            currentUser.login(token);
        }catch(UnknownAccountException uae){
            redirectAttributes.addFlashAttribute("message", "未知账户");
        }catch(IncorrectCredentialsException ice){
            redirectAttributes.addFlashAttribute("message", "密码不正确");
        }catch(LockedAccountException lae){
            redirectAttributes.addFlashAttribute("message", "账户已锁定");
        }catch(ExcessiveAttemptsException eae){
            redirectAttributes.addFlashAttribute("message", "用户名或密码错误次数大于5次,账户已锁定");
        }catch (DisabledAccountException sae){
            redirectAttributes.addFlashAttribute("message", "帐号已经禁止登录");
        }catch(AuthenticationException ae){
            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
            ae.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "用户名或密码不正确");
        }
        //验证是否登录成功
        if(currentUser.isAuthenticated()){
            //把当前用户放入session
            Session session = currentUser.getSession();
            User tUser = userService.getByUserName(user.getUserName());
            session.setAttribute("user",tUser);
            return "/index";
        }else{
            token.clear();
            return "redirect:login";
        }
    }

}
