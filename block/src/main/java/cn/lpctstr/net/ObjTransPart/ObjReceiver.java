package cn.lpctstr.net.ObjTransPart;

import cn.lpctstr.net.ObjTransPart.Initializer.ObjReceiverInitializer;
import cn.lpctstr.net.cmdTable.PCTable;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Rec port: 10124
 * @Date: 20:23 2019/7/14
 * @Project: netModule
 */
public class ObjReceiver extends ObjTransCommon {

    private PCTable table;

    public ObjReceiver(Builder builder) {
        this.port = builder.port;
        this.tag = builder.tag;
        this.table = builder.table;
    }

    public void begin() {
        new Thread(this).start();
    }

    public void init(){
        ServerBootstrap bootstrapServer = new ServerBootstrap();
        EventLoopGroup boss = new NioEventLoopGroup();
        EventLoopGroup worker = new NioEventLoopGroup();
        bootstrapServer
                .group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childHandler(new ObjReceiverInitializer(table));
        ChannelFuture future = bootstrapServer.bind(port);
        System.out.println("Server starts...");
        try {
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            worker.shutdownGracefully();
            boss.shutdownGracefully();
        }
    }
    @Override
    public void run() {
        init();
    }

    public static class Builder {
        private int port = 10124;
        private String tag = "Unknown";
        public ObjReceiver build() {
            return new ObjReceiver(this);
        }
        private PCTable table;

        public Builder(PCTable table) {
            this.table = table;
        }

        public Builder setTag(String tag) {
            this.tag = tag;
            return this;
        }

        public Builder setPort(int port) {
            this.port = port;
            return this;
        }

    }
}
