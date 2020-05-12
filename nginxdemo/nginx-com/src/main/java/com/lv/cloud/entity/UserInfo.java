package com.lv.cloud.entity;

import lombok.Data;
import lombok.ToString;

/**
 * Write class comments
 * hereUser: lvzhen
 * Date: 2020/4/30 12:02
 * version $Id: UserInfo.java$
 */
@Data
@ToString
public class UserInfo {

    private int id;
    private String name;
    private int age;

    public UserInfo() {
    }

    public UserInfo(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
