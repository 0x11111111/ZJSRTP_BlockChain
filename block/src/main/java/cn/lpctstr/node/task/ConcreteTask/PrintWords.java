package cn.lpctstr.node.task.ConcreteTask;

import cn.lpctstr.node.task.PreTask;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 16:45 2019/6/27
 * @Project: ZJSRTP
 */
public class PrintWords extends PreTask {
    public PrintWords() {
        super(()-> System.out.println("Print One Word!"));
    }
}
