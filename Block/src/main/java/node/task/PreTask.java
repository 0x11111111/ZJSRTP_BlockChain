package node.task;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 11:45 2019/6/26
 * @Project: ZJSRTP
 */
public abstract class PreTask extends ITaskObj {
    public PreTask(Runnable task) {
        this("",task);
    }


    public PreTask(String id, Runnable task) {
        super(id, task);
        this.taskType=TaskType.Pre;
    }
}
