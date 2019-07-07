package node.data;

import node.data.model.Stud_Info;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 13:05 2019/6/29
 * @Project: ZJSRTP
 */


public enum DataManager{
    INSTANCE;

    private List<Stud_Info> list;

    private DataManager(){ list = new ArrayList<>();}

    public static void digest(Object o){
        if(o instanceof Stud_Info){
            INSTANCE.list.add((Stud_Info) o);
        }
    }

    public static void print(){
        INSTANCE.list.stream().forEach(Stud_Info -> System.out.println("!!!!!!!"));
    }

}







//public class DataManager {
//
//
//    private DataManager(){ list = new ArrayList<>();
//    }
////
////    private static DataManager dataManager;
////    public static DataManager getInstance(){
////        if(dataManager ==null){
////            synchronized (DataManager.class){
////                if(dataManager ==null)
////                    dataManager= new DataManager();
////            }
////        }
////
////        return dataManager;
////    }
//
//
//
//
//
//    private List<Stud_Info> list;
//}
