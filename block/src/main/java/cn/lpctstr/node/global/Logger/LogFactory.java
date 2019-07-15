package cn.lpctstr.node.global.Logger;

import cn.lpctstr.node.global.Logger.Log.FileOutLog;
import cn.lpctstr.node.global.Logger.Log.Log;
import cn.lpctstr.node.global.Logger.Log.SimpleLog;
import cn.lpctstr.node.global.Logger.Log.UnknowObj;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Log Factory
 * @Date: 11:16 2019/6/27
 * @Project: ZJSRTP
 *
 *
 *
 * Each Log will bind one Object which point the origin of such log.
 *
 */
public class LogFactory {

    private boolean isConsole;
    private static LogFactory inst = new LogFactory();
    public static Log GetLog(Object o){
        if(inst.isConsole)
            return new SimpleLog(o);
        else
            return new FileOutLog(o);
    }

    private LogFactory() {
        isConsole=true;
    }

    public static Log GetLog(){
        return GetLog(UnknowObj.Get());
    }


}
