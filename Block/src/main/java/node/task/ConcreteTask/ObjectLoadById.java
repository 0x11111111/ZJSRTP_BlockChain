package node.task.ConcreteTask;

import cn.hutool.core.io.FileUtil;
import node.data.DataManager;
import node.global.Global;
import node.task.PreTask;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 12:53 2019/6/29
 * @Project: ZJSRTP
 */
public class ObjectLoadById extends PreTask {

    public ObjectLoadById(String id) {
        super(()->{
            try {
                ObjectInputStream inputStream= new ObjectInputStream(new FileInputStream(FileUtil.touch(Global.INSTANCE.getConfig_ini().get("Path","DataPath") +"/_"+id+".bin")));
                DataManager.digest(inputStream.readObject());
                inputStream.close();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }
}
