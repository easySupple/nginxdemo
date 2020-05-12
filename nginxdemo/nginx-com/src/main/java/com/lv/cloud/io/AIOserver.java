package com.lv.cloud.io;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;
import java.util.function.Function;

/**
 * Write class comments
 * hereUser: lvzhen
 * Date: 2020/5/9 11:19
 * version $Id: AIOserver.java$
 */
public class AIOserver {

    private static final int port = 10092;

    public static void server() {
        Thread thread = new Thread(() -> {
            AsynchronousChannelGroup acg = null;

            try {
                acg = AsynchronousChannelGroup.withThreadPool(
                        new ThreadPoolExecutor(4, 4, 60L,
                                TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>()));
                AsynchronousServerSocketChannel asyServerChannel = AsynchronousServerSocketChannel.
                        open(acg).bind(new InetSocketAddress(InetAddress.getLocalHost(), port));
                asyServerChannel.accept(null,
                        new CompletionHandler<AsynchronousSocketChannel, AsynchronousServerSocketChannel>() {
                            /**
                             * Invoked when an operation has completed.
                             *
                             * @param result     The result of the I/O operation.
                             * @param attachment
                             */
                            @Override
                            public void completed(AsynchronousSocketChannel result, AsynchronousServerSocketChannel attachment) {
                                // 接收下一个请求
                                asyServerChannel.accept(null, this);

                                try {
                                    Future<Integer> f = result.write(
                                            Charset.defaultCharset().
                                                    encode("多福多寿感受到法国是的发个是的方法."));
                                    f.get();
                                    System.out.println("服务器发送时间：" +
                                            new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").
                                                    format(new Date()));
                                    result.close();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }

                            /**
                             * Invoked when an operation fails.
                             *
                             * @param exc        The exception to indicate why the I/O operation failed
                             * @param attachment
                             */
                            @Override
                            public void failed(Throwable exc, AsynchronousServerSocketChannel attachment) {
                            }
                        });
                acg.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }


    public static void main(String[] args) {
            server();


    }
}
