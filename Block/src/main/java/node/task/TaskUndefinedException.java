package node.task;

import node.global.Global;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 11:58 2019/6/26
 * @Project: ZJSRTP
 */
public class TaskUndefinedException extends Exception {
    public TaskUndefinedException() {
        super(Global.Str().TaskUndefinedException);
    }
}
