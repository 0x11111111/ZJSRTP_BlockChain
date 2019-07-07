package node.task.ConcreteTask;

import cn.hutool.core.io.FileUtil;
import node.data.DataManager;
import node.global.Global;
import node.task.PreTask;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 13:54 2019/7/2
 * @Project: ZJSRTP
 */
public class ObjectLoadByConfig extends PreTask {
    public ObjectLoadByConfig() {
        super(() -> {
            List<String> tmp = Global.getConfig_ini().getGroups();
            tmp.stream().filter(id -> id.charAt(0) == '_')
                    .forEach(id -> {
                        try {
                            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FileUtil.touch(Global.INSTANCE.getConfig_ini().get("Path", "DataPath") + "/" + id + ".bin")));
                            DataManager.digest(inputStream.readObject());
                            log.info(String.format(Global.Str().LoadBlock,id));
                            inputStream.close();
                        } catch (ClassNotFoundException | IOException e) {
                            e.printStackTrace();
                        }
                    });
        });
    }
}
