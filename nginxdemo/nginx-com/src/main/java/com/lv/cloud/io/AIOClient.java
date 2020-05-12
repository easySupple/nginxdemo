package com.lv.cloud.io;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.Future;

/**
 * Write class comments
 * hereUser: lvzhen
 * Date: 2020/5/9 11:31
 * version $Id: AIOClient.java$
 */
public class AIOClient {

    private static final int port = 10092;

    public static void main(String[] args) {
        try {
            AsynchronousSocketChannel channel = AsynchronousSocketChannel.open();

            Future<Void> f = channel.connect(new InetSocketAddress(InetAddress.getLocalHost(),port));
            f.get();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            channel.read(byteBuffer, null, new CompletionHandler<Integer, Void>() {
                /**
                 * Invoked when an operation has completed.
                 *
                 * @param result     The result of the I/O operation.
                 * @param attachment
                 */
                @Override
                public void completed(Integer result, Void attachment) {
                    String string = new String(byteBuffer.array(),0,result);
                    System.out.println("客户端接收到的信息：" + string);
                }

                /**
                 * Invoked when an operation fails.
                 *
                 * @param exc        The exception to indicate why the I/O operation failed
                 * @param attachment
                 */
                @Override
                public void failed(Throwable exc, Void attachment) {
                    exc.printStackTrace();
                    try {
                        channel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
