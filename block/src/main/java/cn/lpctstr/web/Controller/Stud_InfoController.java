package cn.lpctstr.web.Controller;

import cn.lpctstr.web.Model.Command;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 16:13 2019/7/25
 * @Project: ZJSRTP
 */

@RestController
public class Stud_InfoController {

    @PostMapping(path = "stud")
    void update(Command command){
        String c = command.getCmd();
        if(c.equals("add")){
            String[] args = command.getArgs().split("\\|");
            String name =args[0];
            String id =args[1];

        }
    }
}
