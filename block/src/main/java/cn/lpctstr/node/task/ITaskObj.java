package cn.lpctstr.node.task;

import cn.lpctstr.node.global.Logger.Log.Log;
import cn.lpctstr.node.global.Logger.LogFactory;

import java.io.Serializable;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 20:03 2019/6/25
 * @Project: ZJSRTP
 */
public abstract class ITaskObj implements Serializable,TaskCondition {
    protected Runnable task;
    private String id;
    protected static Log log;

    public TaskType getTaskType() {
        return taskType;
    }

    public void start() {
        if (task == null)
            log.error("Task-NullPointer");
        else
            task.run();
    }

    TaskType taskType = TaskType.Undefined;

    public ITaskObj(String id, Runnable task) {
        this.id = id;
        this.task = task;
        log = LogFactory.GetLog(id);
    }


}
