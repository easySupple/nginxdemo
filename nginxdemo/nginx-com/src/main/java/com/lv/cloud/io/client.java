package com.lv.cloud.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Write class comments
 * hereUser: lvzhen
 * Date: 2020/5/9 10:49
 * version $Id: client.java$
 */
public class client {

    private static final int port = 10091;


    public static void main(String[] args) {
        try (Socket clientSocket = new Socket((InetAddress.getLocalHost()), port);) {
            BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            br.lines().forEach(s -> System.out.println("meg:" + s));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
