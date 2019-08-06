package cn.lpctstr.node.global;

import cn.hutool.core.io.FileUtil;
import cn.lpctstr.node.global.Logger.LogFactory;
import cn.lpctstr.node.global.config_part.Config_ini;
import cn.lpctstr.node.global.config_part.StringTable.ITable;
import cn.lpctstr.node.global.config_part.StringTable.cn_Str;
import cn.lpctstr.node.task.ConcreteTask.ObjectLoadByConfig;
import cn.lpctstr.node.task.TaskHandler;

import java.io.File;

/**
 * @Author:LPCTSTR_MSR
 * @Description: The global setting module
 * @Date: 19:42 2019/6/25
 * @Project: ZJSRTP
 */
public enum Global {
    INSTANCE;
    private Global() { }
    public static Config_ini getConfig_ini() {
        return INSTANCE.config_ini;
    }
    Config_ini config_ini;
    private final String path ="config/global_all.ini";
    public TaskHandler handler;
    public ITable table;


//======================================init section================================
    private void init(){
        table = new cn_Str();       //Load String Table
        File tmp =FileUtil.touch(path);
        FileUtil.touch("data/tmp.alter");
        config_ini = new Config_ini(path);
        handler = new TaskHandler();
//      If deploying for the first time, then initialize the environment.
        if (FileUtil.isEmpty(tmp)){
            LogFactory.GetLog(Global.class).info(Global.Str().ConfigNotExist);
            config_init();
            config_save();
        }
        runtime_job();
        config_save();
    }

//==================================================================================

//======================================runtime section=============================

    public void runtime_job(){
//        handler.addTask(new PrintWords());
//        Stud_Info stud_info=new Stud_Info("CJ","001");
//        stud_info.getCourseList().add(new Course("null"));
//        DataManager.digest(stud_info);
        handler.addTask(new ObjectLoadByConfig());
        handler.fire();
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
