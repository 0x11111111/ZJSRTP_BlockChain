package cn.lpctstr.web;

import cn.lpctstr.node.global.Global;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {
        Global.main(args);
        SpringApplication.run(WebApplication.class, args);
    }

}
