package com.springbootdemo.springbootshiro.controller;

import com.springbootdemo.springbootshiro.entity.UserEntity;
import com.springbootdemo.springbootshiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Jiang Hao
 * @Date: 2018-11-29 16:21
 */
@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(String account, String password) {
//        登陆
        return userService.login(account, password);
    }

    @GetMapping(value = {"/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping(value = "/logout")
    public String logout() {
//        注销
        SecurityUtils.getSubject().logout();
        return "logout";
    }

    @PostMapping(value = "/zhuce")
    public String zhuce(UserEntity userEntity) {
        return userService.zhuce(userEntity);
    }

    /**
     * 设置角色限制
     *
     * @return
     */
    @GetMapping(value = "/test1")
    @RequiresRoles(value = "1")
    public String test1() {
        return "test1";
    }

    /**
     * 设置权限设置
     *
     * @return
     */
    @GetMapping(value = "/test2")
    @RequiresPermissions("del")
    public String test2() {
        return "test2";
    }

}
