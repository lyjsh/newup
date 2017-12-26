package com.lyjsh.web.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("index")
public class IndexController {

    @RequestMapping("/main")
    public String toIndex(HttpServletRequest request) {
        System.out.println( request.getAttribute("ctx"));
        return "system/main";
    }
}
