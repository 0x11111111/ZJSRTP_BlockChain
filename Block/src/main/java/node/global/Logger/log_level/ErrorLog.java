package node.global.Logger.log_level;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 11:21 2019/6/27
 * @Project: ZJSRTP
 */
public interface ErrorLog {
    default boolean canError(){
        return true;
    }
}
