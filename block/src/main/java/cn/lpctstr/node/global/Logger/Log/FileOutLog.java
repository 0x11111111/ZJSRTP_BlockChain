package cn.lpctstr.node.global.Logger.Log;

import cn.lpctstr.node.global.Logger.log_level.AlarmLog;
import cn.lpctstr.node.global.Logger.log_level.ErrorLog;
import cn.lpctstr.node.global.Logger.log_level.InfoLog;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 15:33 2019/6/27
 * @Project: ZJSRTP
 *
 *
 *
 *
 *
 * Wait to finish
 */
public class FileOutLog extends Log implements AlarmLog, ErrorLog, InfoLog {
    public FileOutLog(Object o) {
        super(o);
    }

    @Override
    public void info(String p) {

    }

    @Override
    public void alarm(String p) {

    }

    @Override
    public void error(String p) {

    }
}
