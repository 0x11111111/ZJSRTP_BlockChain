package cn.lpctstr.net.cmdTable;

import cn.lpctstr.net.cmdModel.ICommand;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 15:43 2019/7/15
 * @Project: netModule
 */
public abstract class AbstractTable {
    public abstract void put(ICommand cmd) throws InterruptedException;
    public abstract ICommand take();
}
