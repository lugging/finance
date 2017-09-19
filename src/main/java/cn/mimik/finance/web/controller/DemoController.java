package cn.mimik.finance.web.controller;

import cn.mimik.finance.domain.UserPo;
import cn.mimik.finance.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liugang on 2017/9/13.
 */
@Controller
@RequestMapping("user/")
@Slf4j
public class DemoController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(Model model) {
        model.addAttribute("name", "Dear");
        return "test";
    }

    @RequestMapping(value="/user/{user}", method= RequestMethod.GET)
    @ApiOperation(value = "获取用户", notes = "参数描述", code = 200, produces = "application/json")
    public UserPo getUser(@PathVariable Long user) {

        log.info("getUser variable {}" ,user);
        UserPo userPo = new UserPo();
        userPo.setName("XXX");
       return userPo ;
    }

    @RequestMapping(value="/userList", method= RequestMethod.GET)
    @ApiOperation(value = "获取所有用户", notes = "参数描述", code = 200, produces = "application/json")
    public Object getUserList() {

        log.info("getUserList");

        return userService.selectList();
    }


}
