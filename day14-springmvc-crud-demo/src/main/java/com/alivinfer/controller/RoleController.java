package com.alivinfer.controller;

import com.alivinfer.domain.Role;
import com.alivinfer.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Fer
 * @version 1.0
 * @description 角色控制类
 * @date 2025/3/30
 */

@RequestMapping("/role")
@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * 处理保存角色的请求
     * 该方法接收一个角色对象，调用角色服务的保存方法，并重定向到角色列表页面
     *
     * @param role 要保存的角色对象
     * @return 重定向到角色列表页面的 URL
     */
    @RequestMapping("/save")
    public String save(Role role) {
        // 调用角色服务的保存方法，保存角色对象
        roleService.save(role);

        // 保存成功后，重定向到角色列表页面
        return "redirect:/role/list";
    }

    @RequestMapping( "/list")
    public ModelAndView list(){
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.list();
        //设置模型
        modelAndView.addObject("roleList",roleList);
        //设置视图
        modelAndView.setViewName("role-list");
        System.out.println(roleList);
        return modelAndView;
    }

}
