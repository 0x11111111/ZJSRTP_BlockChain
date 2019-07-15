package cn.lpctstr.net.ObjTransPart.handler;

import cn.lpctstr.net.cmdModel.TransCommand;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 12:03 2019/7/14
 * @Project: netModule
 */
public class ObjReceiverHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if(msg instanceof TransCommand) {
            TransCommand transCommand= (TransCommand) msg;
            final String[] tmp = {new String()};
            tmp[0]+=transCommand.getDate();
            tmp[0] +=" 命令:"+transCommand.getCmd()+"参数为 ";
            transCommand.getArgs().forEach(str-> tmp[0] +=(str+ " "));
            System.out.println(tmp[0]);
        }
        ctx.fireChannelRead(msg);   //传递给下一个Handler
    }
}
