package cn.lpctstr.cmdTable;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 15:45 2019/7/15
 * @Project: netModule
 */
public class PCTable<T> extends AbstractTable<T> {
    private int head;   //Where to take
    private int tail;   //Where to put
    private int c;    //Num of all Cmds
    private final T[] buf;

    /**
     *
     * @param TypeBuf Actually this can define both the size and the type.
     *                Java never allow to make native array of generics for its safety.By Lpctstr 7/25
     */
    public PCTable(T[] TypeBuf) {
        head=0;
        tail=0;
        c=0;
        this.buf=TypeBuf;
    }

    @Override
    synchronized public void put(T obj) {
        while(c>=buf.length) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buf[tail]=obj;
        tail =(tail+1)%buf.length;
        c++;
        notifyAll();
    }

    @Override
    synchronized public T take() {
        while(c<=0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        T obj = buf[head];
        head = (head+1)%buf.length;
        c--;
        notifyAll();
        return obj;
    }


    /*
        @Override
    public void put(Object obj) throws InterruptedException {
        while(c>=buf.length) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buf[tail]=obj;
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

     */
}
