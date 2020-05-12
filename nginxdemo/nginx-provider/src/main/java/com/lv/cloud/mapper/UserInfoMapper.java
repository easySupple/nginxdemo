package com.lv.cloud.mapper;

import com.lv.cloud.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Write class comments
 * hereUser: lvzhen
 * Date: 2020/4/30 12:10
 * version $Id: UserInfoMapper.java$
 */
@Mapper
public interface UserInfoMapper {

    public boolean addUser(UserInfo user);

    public UserInfo getUser(int id);

    public List<UserInfo> getUsers();

}
