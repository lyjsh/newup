package com.lyjsh.web.controller.system;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.lyjsh.entity.system.Organization;
import com.lyjsh.system.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("organization")
@Controller
public class OrgController {

    @Autowired
    private OrgService orgService;

    /**
     * @Author wl
     * @Date 2017/12/27 20:46
     * @Todo 部门首页
     */
    @RequestMapping("/index")
    public ModelAndView toIndexView(ModelAndView modelAndView) {
        Page page = new Page(1,10);
        Organization organization = new Organization();
        organization.setPId(Organization.ROOT_ORG_ID);
        PageInfo<Organization> pageInfo = orgService.pageOrg(page,organization);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.addObject("view","/system/org/index.ftl");
        return modelAndView;
    }

    /**
     * @Author wl
     * @Date 2017/12/27 21:36
     * @Todo 部门新增页面
     */

    @GetMapping("/view/add")
    public ModelAndView toAddView(ModelAndView modelAndView) {
        modelAndView.addObject("view","/system/org/add.ftl");
        Page page = new Page(1,10);
        Organization organization = new Organization();
        organization.setPId(Organization.ROOT_ORG_ID);
        PageInfo<Organization> pageInfo = orgService.pageOrg(page,organization);
        modelAndView.addObject("pageInfo",pageInfo);
        return modelAndView;
    }
}
