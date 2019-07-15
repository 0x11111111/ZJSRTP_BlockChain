package cn.lpctstr.node.task;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 21:13 2019/6/26
 * @Project: ZJSRTP
 */
public interface TaskCondition {

    default boolean CanExcute() {
        return true;
    }

}
