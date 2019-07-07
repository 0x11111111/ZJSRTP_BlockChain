package node.task;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 20:57 2019/6/26
 * @Project: ZJSRTP
 */
public class ScheduleTask extends ITaskObj {
    @Override
    public void start() {

    }

    public ScheduleTask(String id, Runnable task) {
        super(id, task);
        this.taskType=TaskType.Schedule;
    }

    public ScheduleTask(Runnable task) {
        this("NoTag",task);
    }
}
