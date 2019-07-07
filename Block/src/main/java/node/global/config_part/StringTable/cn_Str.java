package node.global.config_part.StringTable;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 21:46 2019/6/26
 * @Project: ZJSRTP
 */
public class cn_Str extends ITable {
    public cn_Str() {
        TaskUndefinedException = "未定义Task!";
        ConfigNotExist = "配置文件不存在,正在创建新配置文件.";
        ConfigHasLoaded = "配置文件已加载.";
        LoadBlock ="已加载模块%s.";
    }


}
