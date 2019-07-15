package cn.lpctstr.node.task;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 11:45 2019/6/26
 * @Project: ZJSRTP
 */
public abstract class PostTask extends ITaskObj {

    public PostTask(String id, Runnable task) {
        super(id, task);
        this.taskType=TaskType.Post;
    }

    public PostTask(Runnable task) {
        this("",task);
    }
}
