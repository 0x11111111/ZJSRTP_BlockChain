package cn.lpctstr.node.global.Logger.Log;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 14:46 2019/6/27
 * @Project: ZJSRTP
 */
public class UnknowObj {

    private static UnknowObj obj;

    private UnknowObj() { }

    public static UnknowObj Get(){
        if(obj==null) {
            synchronized (UnknowObj.class) {
                if (obj == null)
                    obj = new UnknowObj();
            }
        }
        return obj;
    }
    @Override
    public String toString() {
        return "Unknown class";
    }
}
