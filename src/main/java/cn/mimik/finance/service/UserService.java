package cn.mimik.finance.service;

import cn.mimik.finance.domain.UserPo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liugang on 2017/9/13.
 */
@Service
public class UserService {

    public List<UserPo> selectList(){
        UserPo userPo = new UserPo();
        userPo.setId(1);
        userPo.setAddress("北京");
        userPo.setName("张三");

        List<UserPo> userPos = new ArrayList<UserPo>();

        userPos.add(userPo);
        return userPos;
    }
}
