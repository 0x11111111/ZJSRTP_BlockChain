package cn.lpctstr.node.global.Logger.Log;

import java.io.Serializable;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 11:26 2019/6/27
 * @Project: ZJSRTP
 */
public abstract class Log implements Serializable {

    Object object;
    public abstract void info(String p);

    Log(Object o) {
        this.object =o;
    }

    public abstract void alarm(String p);

    public abstract void error(String p);
}
