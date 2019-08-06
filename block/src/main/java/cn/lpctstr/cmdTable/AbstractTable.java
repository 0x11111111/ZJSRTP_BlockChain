package cn.lpctstr.cmdTable;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 15:43 2019/7/15
 * @Project: netModule
 */
public abstract class AbstractTable<T> {
    public abstract void put(T obj) throws InterruptedException;
    public abstract T take();
}
