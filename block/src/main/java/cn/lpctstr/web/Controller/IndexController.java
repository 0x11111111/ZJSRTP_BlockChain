package cn.lpctstr.web.Controller;

import cn.lpctstr.node.global.Global;
import cn.lpctstr.web.Model.Command;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 20:41 2019/7/7
 * @Project: ZJSRTP
 */

@Controller
public class IndexController {

//    @RequestMapping(method = RequestMethod.GET, path = "/")
    @RequestMapping("/")
    public String index(ModelMap model) {
        return "example";
    }


    @ResponseBody
    @PostMapping(path = "node")
    void getPostCmd(Command command){
        String c = command.getCmd();
        System.out.println(c);
        if(c.equals("fire"))
            Global.INSTANCE.handler.fire();
    }
}
