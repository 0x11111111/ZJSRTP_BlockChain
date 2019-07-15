package cn.lpctstr.net.cmdTable;

import cn.lpctstr.net.cmdModel.ICommand;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 15:45 2019/7/15
 * @Project: netModule
 */
public class PCTable extends AbstractTable {
    private int head;   //Where to take
    private int tail;   //Where to put
    private int c;    //Num of all Cmds
    private final ICommand[] buf;

    /**
     *
     * @param size Buffer Max Length
     *
     */
    public PCTable(int size) {
        head=0;
        tail=0;
        c=0;
        buf = new ICommand[size];
    }

    @Override
    public synchronized void put(ICommand cmd) {
        //Add Cmd
        while(c>=buf.length) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buf[tail]=cmd;
        tail =(tail+1)%buf.length;
        c++;
        notifyAll();
    }

    @Override
    public synchronized ICommand take() {
        //Get Cmd
        while(c<=0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ICommand command = buf[head];
        head = (head+1)%buf.length;
        c--;
        notifyAll();
        return command;
    }

}
