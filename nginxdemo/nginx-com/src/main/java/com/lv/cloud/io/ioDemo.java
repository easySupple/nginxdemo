package com.lv.cloud.io;

import com.sun.org.apache.bcel.internal.generic.Select;
import org.junit.Test;
import sun.nio.ch.ThreadPool;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Write class comments
 * hereUser: lvzhen
 * Date: 2020/5/9 10:23
 * version $Id: ioDemo.java$
 */
public class ioDemo {


    private static final int port = 10091;

    @Test
    public void test1() {

        ThreadPoolExecutor executor = new ThreadPoolExecutor
                (4, 4, 60L,
                        TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());



    }

    @Test
    public void test2() {

    }
}
