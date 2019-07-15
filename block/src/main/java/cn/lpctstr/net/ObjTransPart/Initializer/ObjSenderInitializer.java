package cn.lpctstr.net.ObjTransPart.Initializer;

import cn.lpctstr.net.ObjTransPart.handler.ObjSenderHandler;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 20:40 2019/7/14
 * @Project: netModule
 */
public class ObjSenderInitializer extends ChannelInitializer<Channel> {
    protected void initChannel(Channel ch) throws Exception {
        ch.pipeline()
                .addLast(
                        new ObjectEncoder(),
                        new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)),
                        new ObjSenderHandler()
                );
    }
}
