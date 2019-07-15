package cn.lpctstr.node.global.config_part;

import cn.lpctstr.node.task.ITaskObj;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Serial_Node
 * @Date: 19:49 2019/6/25
 * @Project: ZJSRTP
 *
 *
 *
 * Class Serial_Node is the container of the objects needing serializing.
 * task @pre and task @post are called before and later serializing, respectively.
 * Don't create by yourself, it should be registered by global configuration.
 *
 *
 */
public class Serial_Node {
    private ITaskObj pre;
    private ITaskObj post;
    private Object object;


    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public ITaskObj getPre() {
        return pre;
    }

    public void setPre(ITaskObj pre) {
        this.pre = pre;
    }

    public ITaskObj getPost() {
        return post;
    }

    public void setPost(ITaskObj post) {
        this.post = post;
    }
}
