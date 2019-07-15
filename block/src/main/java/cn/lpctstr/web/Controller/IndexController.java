package cn.lpctstr.web.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 20:41 2019/7/7
 * @Project: ZJSRTP
 */

@Controller
@RequestMapping("/")
public class IndexController {

//    @RequestMapping(method = RequestMethod.GET, path = "/")
    @RequestMapping("")
    public String index(ModelMap model) {
        return "index";
    }
}
