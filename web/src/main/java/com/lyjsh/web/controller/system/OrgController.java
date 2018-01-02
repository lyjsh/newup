package com.lyjsh.web.controller.system;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.lyjsh.Exception.BussException;
import com.lyjsh.common.ExecuteResult;
import com.lyjsh.entity.system.Organization;
import com.lyjsh.system.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
        modelAndView.setViewName("system/layout");
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
        modelAndView.setViewName("system/layout");
        Page page = new Page(1,10);
        Organization organization = new Organization();
        organization.setPId(Organization.ROOT_ORG_ID);
        PageInfo<Organization> pageInfo = orgService.pageOrg(page,organization);
        modelAndView.addObject("pageInfo",pageInfo);
        return modelAndView;
    }

    /**
     * @Author wl
     * @Date 2017/12/29 10:28
     * @Todo 部门新增
     */
    @PostMapping("/save")
    @ResponseBody
    public ExecuteResult save(Organization organization) {
        try {
            boolean result = orgService.save(organization);
            if (result) {
                return ExecuteResult.success(organization);
            }
        } catch (BussException e) {
            e.printStackTrace();
            return ExecuteResult.bussError(e.getMessage(),organization);
        } catch (Exception exc) {
            exc.printStackTrace();
            return ExecuteResult.error(organization,exc.getMessage());
        }
        return ExecuteResult.oprateFault("操作失败",organization);
    }

    /**
     * @Author wl
     * @Date 2017/12/29 10:28
     * @Todo 部门修改
     */
    @PostMapping("/uddate")
    public ExecuteResult update(Organization organization) {
        try {
            boolean result = orgService.update(organization);
            if (result) {
                return ExecuteResult.success(organization);
            }
        }catch (BussException buss) {
            buss.printStackTrace();
            return ExecuteResult.bussError(buss.getMessage(),organization);
        }catch (Exception e) {
            return ExecuteResult.error(organization,e.getMessage());
        }
        return ExecuteResult.oprateFault("操作失败",organization);
    }
}
