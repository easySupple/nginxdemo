package com.lv.cloud.io;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
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
 * Date: 2020/5/9 10:48
 * version $Id: server.java$
 */
public class server {


    private static final int port = 10091;


    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor
                (4, 4, 60L,
                        TimeUnit.SECONDS, new LinkedBlockingQueue<>());

        executor.execute(() -> {
            try (Selector selector = Selector.open();
                 ServerSocketChannel ssc = ServerSocketChannel.open();) {

                ssc.bind(new InetSocketAddress(InetAddress.getLocalHost(), port));
                ssc.configureBlocking(false);
                ssc.register(selector, SelectionKey.OP_ACCEPT);
                while (true) {
                    selector.select();
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iterator = selectionKeys.iterator();
                    while (iterator.hasNext()) {
                        SelectionKey sk = iterator.next();
                        try (SocketChannel channel = ((ServerSocketChannel) sk.channel()).accept();) {
                            channel.write(Charset.defaultCharset().encode("真的"));
                        }
                        iterator.remove();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
    }
}
