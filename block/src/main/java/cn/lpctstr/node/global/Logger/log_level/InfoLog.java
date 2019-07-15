package cn.lpctstr.node.global.Logger.log_level;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 11:20 2019/6/27
 * @Project: ZJSRTP
 */
public interface InfoLog {
    default boolean canInfo(){
        return true;
    }
}
