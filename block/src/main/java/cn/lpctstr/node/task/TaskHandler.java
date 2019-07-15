package cn.lpctstr.node.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 21:04 2019/6/26
 * @Project: ZJSRTP
 */
public class TaskHandler {
    private List<ITaskObj> taskList;

    public TaskHandler() {
        taskList = new ArrayList<>();
    }

    public void addTask(ITaskObj obj){
        taskList.add(obj);
    }

    private void TypeTaskFire(TaskType ... types){
        Arrays.stream(types).forEach(type -> {
            for(ITaskObj obj:taskList)
                if(obj.getTaskType()== type)
                    obj.start();
        });

    }

    public void fire(){
        TypeTaskFire(TaskType.Post,TaskType.Pre,TaskType.Schedule);
    }
}
