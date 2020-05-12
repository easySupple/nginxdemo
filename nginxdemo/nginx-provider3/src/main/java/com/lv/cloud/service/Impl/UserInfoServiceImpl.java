package com.lv.cloud.service.Impl;

import com.lv.cloud.Result.ResultMsg;
import com.lv.cloud.entity.UserInfo;
import com.lv.cloud.mapper.UserInfoMapper;
import com.lv.cloud.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Write class comments
 * hereUser: lvzhen
 * Date: 2020/4/30 13:49
 * version $Id: UserInfoServiceImpl.java$
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired(required = false)
    private UserInfoMapper userInfoMapper;

    @Override
    public boolean addUser(UserInfo user) {
        return userInfoMapper.addUser(user);
    }

    @Override
    public ResultMsg getUser(int id) {
        String provider = "provider3";
        System.out.println(provider + "微服务在响应客户端请求……");
        UserInfo user = userInfoMapper.getUser(id);
        System.out.println("用户信息：" + user == null ? "查询为空。" : user.toString());
        ResultMsg resultMsg = new ResultMsg(user, provider);
        return resultMsg;
    }

    @Override
    public List<UserInfo> getUsers() {
        return userInfoMapper.getUsers();
    }
}
