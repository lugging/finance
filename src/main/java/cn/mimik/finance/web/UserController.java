package cn.mimik.finance.web;

import cn.mimik.finance.domain.UserPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by liugang on 2017/9/13.
 */
@RestController
@Slf4j
public class UserController {

    @RequestMapping(value="/user/{user}", method= RequestMethod.GET)
    public UserPo getUser(@PathVariable Long user) {

        log.info("getUser variable {}" ,user);

       return UserPo.builder().name("张三").build();
    }
}
