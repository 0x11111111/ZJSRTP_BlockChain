package node.global;

import cn.hutool.core.io.FileUtil;
import node.data.DataManager;
import node.data.model.Course;
import node.data.model.Stud_Info;
import node.global.Logger.LogFactory;
import node.global.config_part.Config_ini;
import node.global.config_part.StringTable.ITable;
import node.global.config_part.StringTable.cn_Str;
import node.task.ConcreteTask.ObjectStore;
import node.task.ConcreteTask.PrintWords;
import node.task.TaskHandler;

import java.io.File;

/**
 * @Author:LPCTSTR_MSR
 * @Description: The global setting module
 * @Date: 19:42 2019/6/25
 * @Project: ZJSRTP
 */
public enum Global {
    INSTANCE;

    public static Config_ini getConfig_ini() {
        return INSTANCE.config_ini;
    }

    Config_ini config_ini;
    private final String path ="config/global_all.ini";
    public TaskHandler handler;
    public ITable table;

    private Global() {
    }


    private void init(){
        table = new cn_Str();       //Load String Table
        File tmp =FileUtil.touch(path);
        FileUtil.touch("data/tmp.alter");
        config_ini = new Config_ini(path);
        if (FileUtil.isEmpty(tmp)){
            LogFactory.GetLog(Global.class).info(Global.Str().ConfigNotExist);
            config_init();
            config_save();
        }

        handler = new TaskHandler();
        handler.addTask(new PrintWords());

        Stud_Info stud_info=new Stud_Info("CJ","001");
        stud_info.getCourseList().add(new Course("null","null"));
        DataManager.digest(stud_info);
        handler.addTask(new ObjectStore("test4",stud_info));
        handler.addTask(new ObjectStore("test5",stud_info));
        handler.addTask(new ObjectStore("test6",stud_info));
//        handler.addTask(new ObjectLoadByConfig());
//        handler.addTask(new ObjectStore(stud_info));
        handler.fire();
        DataManager.print();
        config_save();
    }

    private void config_save() {
        config_ini.store(path);
    }

    public static ITable Str() {
        return INSTANCE.table;
    }


    /**
     * Initialize one new config.
     */
    private void config_init(){
        config_ini.set("Description","1","Block Configuration.");
        config_ini.set("Path","DataPath","data");   //./data is wrong usage as it's AbsolutePath( data is relativePath)

        /**
         *
         * config code block
         */
    }


    public static void main(String[] args){
        INSTANCE.init();
    }

}
