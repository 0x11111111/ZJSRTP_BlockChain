package cn.lpctstr.net.ObjTransPart.Initializer;

import cn.lpctstr.net.ObjTransPart.handler.CmdReceiver;
import cn.lpctstr.net.ObjTransPart.handler.ObjReceiverHandler;
import cn.lpctstr.cmdTable.PCTable;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 20:33 2019/7/14
 * @Project: netModule
 */
public class ObjReceiverInitializer extends ChannelInitializer<Channel> {

    public ObjReceiverInitializer(PCTable table) {
        this.table = table;
    }

    private PCTable table;

    protected void initChannel(Channel ch) {
        ch.pipeline()
                .addLast(
                        new ObjectEncoder(),
                        new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)),
                        new ObjReceiverHandler(),
                        new CmdReceiver(table)
                );
    }
}
