package com.lv.cloud.Result;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Write class comments
 * hereUser: lvzhen
 * Date: 2020/5/11 16:00
 * version $Id: ResultMsg.java$
 */
@Data
@ToString
public class ResultMsg implements Serializable {


    private static final String SUCCESS = "00";

    private String RtCode;
    private String RtTime;
    private Object RtInfo;
    private String provider;

    public ResultMsg() {
        this.RtCode = SUCCESS;
        this.RtTime = new SimpleDateFormat("yyyyMMddHHmmss",
                Locale.getDefault()).format(new Date());
    }

    public ResultMsg(String success, String rtTime, Object rtInfo, String provider) {
        this.RtCode = success;
        this.RtTime = rtTime;
        this.RtInfo = rtInfo;
        this.provider = provider;
    }

    public ResultMsg(Object rtInfo, String provider) {
        this();
        this.setRtInfo(rtInfo);
        this.setProvider(provider);
    }
}
