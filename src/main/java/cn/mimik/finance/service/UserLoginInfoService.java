package cn.mimik.finance.service;

import cn.mimik.finance.domain.UserLoginInfoPo;
import cn.mimik.finance.mapper.UserLoginInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liugang on 2017/9/18.
 */
@Service
public class UserLoginInfoService {

    @Autowired
    private UserLoginInfoMapper userLoginInfoMapper;


    public UserLoginInfoPo login(UserLoginInfoPo po){
        UserLoginInfoPo userLoginInfoPo =  userLoginInfoMapper.selectOne(po);
        return userLoginInfoPo;
    }

    public void registUser(UserLoginInfoPo po){
        userLoginInfoMapper.insert(po);
    }


    public void updatePwd(UserLoginInfoPo paramPo){
        userLoginInfoMapper.update(paramPo);
    }

}
