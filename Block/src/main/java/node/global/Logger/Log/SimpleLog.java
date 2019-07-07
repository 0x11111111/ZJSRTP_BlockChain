package node.global.Logger.Log;

import cn.hutool.core.date.DateUtil;
import node.global.Logger.log_level.AlarmLog;
import node.global.Logger.log_level.ErrorLog;
import node.global.Logger.log_level.InfoLog;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 14:18 2019/6/27
 * @Project: ZJSRTP
 */
public class SimpleLog extends Log implements AlarmLog, ErrorLog, InfoLog {
    public SimpleLog(Object o) {
        super(o);
    }
    @Override
    public void info(String p) {
        System.out.println("[INFO]"+DateUtil.date()+" "+ object.toString()+"  : "+p);
    }

    @Override
    public void alarm(String p) {
        System.out.println("[ALARM]"+DateUtil.date()+" "+ object.toString()+"  : "+p);
    }

    @Override
    public void error(String p) {
        System.out.println("[ERROR]"+DateUtil.date()+" "+ object.toString()+"  : "+p);
    }
}
