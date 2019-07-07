package node.global.Logger;

import node.global.Logger.Log.Log;
import node.global.Logger.Log.FileOutLog;
import node.global.Logger.Log.SimpleLog;
import node.global.Logger.Log.UnknowObj;

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
