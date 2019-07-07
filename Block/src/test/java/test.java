import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Console;
import node.data.model.Course;
import node.data.util.MerkleTree;
import node.data.model.Stud_Info;
import node.global.Global;
import node.global.Logger.LogFactory;
import node.global.config_part.Config_ini;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 21:09 2019/6/25
 * @Project: ZJSRTP
 */
public class test {

    @Test
    public void fun(){
        List<String> data= Arrays.asList("text1","text2","text4","text5");
        MerkleTree tree=new MerkleTree(data);
        System.out.println("!");
    }


    @Test
    public void serialize(){
        Stud_Info stud_info=new Stud_Info("CJ","001");
        stud_info.getCourseList().add(new Course("null","null"));
        try {
            FileOutputStream fo=new FileOutputStream("block.bin");
            ObjectOutputStream op=new ObjectOutputStream(fo);
            op.writeObject(stud_info);
            op.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    @Test
    public void de_serialize(){
        try {
            ObjectInputStream inputStream= new ObjectInputStream(new FileInputStream("block.bin"));
            Stud_Info info = (Stud_Info) inputStream.readObject();
            System.out.println(info.getCourseList());


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


    @Test
    public void Str_table(){
        System.out.println(Global.Str().TaskUndefinedException);
    }


    @Test
    public void Get_setting() throws IOException {
        String path =this.getClass().getResource("/") + "/config/global.ini";
        Config_ini config_ini;
        try {
            config_ini = new Config_ini(path);
        }catch (Exception e){
            FileUtil.touch(path);
            config_ini = new Config_ini(path);
        }

        config_ini.set("A","B","C");
        Console.error(config_ini.get("A","B"));
        config_ini.store(path);
    }

    @Test
    public void log(){
        LogFactory.GetLog().info("!!!");
        LogFactory.GetLog(this.getClass()).info("!!!");
    }
}
