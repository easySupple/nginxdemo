package com.lv.cloud.controller;

import com.lv.cloud.Result.ResultMsg;
import com.lv.cloud.entity.UserInfo;
import com.lv.cloud.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Write class comments
 * hereUser: lvzhen
 * Date: 2020/4/30 13:51
 * version $Id: UserInfoController.java$
 */
@RestController
public class UserInfoController {


    @Autowired
    private UserInfoService service;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public boolean addUser(@RequestBody UserInfo user) {
        boolean flag = service.addUser(user);
        return flag;
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResultMsg getUser(@PathVariable("id") int id, @RequestParam(required = false) String token) {
        System.out.println("token:" + token);
        ResultMsg user = service.getUser(id);
        return user;
    }

    @RequestMapping(value = "/getUser/list", method = RequestMethod.GET)
    public List<UserInfo> getUsers() {
        List<UserInfo> users = service.getUsers();
        return users;
    }

}
