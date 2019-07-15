package cn.lpctstr.net.ObjTransPart;

import cn.lpctstr.net.ObjTransPart.Initializer.ObjSenderInitializer;
import cn.lpctstr.net.ObjTransPart.Model.ITransModel;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Send Port 10124
 * @Date: 20:26 2019/7/14
 * @Project: netModule
 */
public class ObjSender extends ObjTransCommon {
    public ObjSender(Builder builder) {
        this.address = builder.address;
        this.port = builder.port;
        this.tag = builder.tag;
    }

    public void begin() {
        Bootstrap bootstrap = new Bootstrap();
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        bootstrap
                .group(eventLoopGroup)
                .channel(NioSocketChannel.class)
                .handler(new ObjSenderInitializer());
        try {
            this.channel = bootstrap.connect(address, port).sync().channel();
//      channel.writeAndFlush(new testModel(a,b));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void write(ITransModel model){
        channel.writeAndFlush(model);
    }

    @Override
    public void run() {
        new Thread(this).start();
    }

    public static class Builder {
        private String address;
        private int port = 10124;
        private String tag ="unknown";


        public Builder(String address) {
            this.address = address;
        }

        public ObjSender build() {
            return new ObjSender(this);
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setPort(int port) {
            this.port = port;
            return this;
        }

        public Builder setTag(String tag) {
            this.tag = tag;
            return this;
        }

    }


}
