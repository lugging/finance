package cn.mimik.finance.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by liugang on 2017/9/18.
 */
@Controller
public class LoginController {

    @RequestMapping("/")
    public String login(){
        return "login";
    }
}
