package com.lv.cloud.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Write class comments
 * hereUser: lvzhen
 * Date: 2020/5/8 15:46
 * version $Id: Md5Utils.java$
 */
public class Md5Utils {

    private static final String hexDigIts[] = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};

    public static String MD5Encode(String str){
        String encode = "";

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            encode = byteArrayToHexString(md.digest(str.getBytes()));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return  encode;
    }

    public static String byteArrayToHexString(byte b[]){
        StringBuffer resultSb = new StringBuffer();
        for(int i = 0; i < b.length; i++){
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    public static String byteToHexString(byte b){
        int n = b;
        if(n < 0){
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigIts[d1] + hexDigIts[d2];
    }
}
