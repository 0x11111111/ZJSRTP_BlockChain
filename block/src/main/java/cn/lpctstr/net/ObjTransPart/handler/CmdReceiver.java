package cn.lpctstr.net.ObjTransPart.handler;

import cn.lpctstr.net.cmdModel.ICommand;
import cn.lpctstr.cmdTable.PCTable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 16:54 2019/7/15
 * @Project: netModule
 */
public class CmdReceiver extends ChannelInboundHandlerAdapter {

    public CmdReceiver(PCTable<ICommand> table) {
        this.table = table;
    }

    private PCTable<ICommand> table;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        table.put((ICommand) msg);
    }
}
