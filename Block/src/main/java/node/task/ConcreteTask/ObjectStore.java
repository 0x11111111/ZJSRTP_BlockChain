package node.task.ConcreteTask;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Console;
import node.global.Global;
import node.task.PostTask;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 21:10 2019/6/27
 * @Project: ZJSRTP
 */
public class ObjectStore extends PostTask {
    Object obj;
    public ObjectStore(Object obj) {
        this(obj.getClass().getName(),obj);
    }

    public ObjectStore(String id, Object obj ) {
        super(id,()->{
            try {
                FileOutputStream fo=new FileOutputStream(FileUtil.touch(Global.INSTANCE.getConfig_ini().get("Path","DataPath") +"/_"+id+".bin"));
                ObjectOutputStream op=new ObjectOutputStream(fo);
                op.writeObject(obj);
                Global.getConfig_ini().set("_"+id,"File","_"+id+".bin");
                Console.log("Store"+"_"+id);
                op.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
