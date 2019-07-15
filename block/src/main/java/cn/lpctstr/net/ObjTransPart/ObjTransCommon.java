package cn.lpctstr.net.ObjTransPart;


import io.netty.channel.Channel;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 19:22 2019/7/14
 * @Project: netModule
 */
public abstract class ObjTransCommon implements Runnable{
    String address;
    int port;
    String tag;
    protected Channel channel;
    public abstract void begin();
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

}
