package com.lv.cloud.util;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Write class comments
 * hereUser: lvzhen
 * Date: 2020/5/8 15:54
 * version $Id: Base64Util.java$
 */
public class Base64Util {

    private static final String UTF_8 = "UTF-8";


    /**
     * 解密
     * @param inputData
     * @return
     */
    public static String decodeData(String inputData) {
        try {
            if (null == inputData) {
                return null;
            }
            return new String(Base64.getDecoder().decode(inputData.getBytes(UTF_8)), UTF_8);
        } catch (UnsupportedEncodingException e) {
        }
        return null;
    }

    /**
     * 加密
     * @param inputData
     * @return
     */
    public static String encodeData(String inputData) {
        try {
            if (null == inputData) {
                return null;
            }
            return new String(Base64.getEncoder().encode(inputData.getBytes(UTF_8)), UTF_8);
        } catch (UnsupportedEncodingException e) {
        }
        return null;
    }
}
