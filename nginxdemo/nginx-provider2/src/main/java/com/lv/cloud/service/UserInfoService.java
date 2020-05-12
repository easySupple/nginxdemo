package com.lv.cloud.service;

import com.lv.cloud.Result.ResultMsg;
import com.lv.cloud.entity.UserInfo;

import java.util.List;

/**
 * Write class comments
 * hereUser: lvzhen
 * Date: 2020/4/30 13:48
 * version $Id: UserInfoService.java$
 */
public interface UserInfoService {
    public boolean addUser(UserInfo user);

    public ResultMsg getUser(int id);

    public List<UserInfo> getUsers();
}
