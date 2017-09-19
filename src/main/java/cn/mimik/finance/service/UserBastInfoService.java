package cn.mimik.finance.service;

import cn.mimik.finance.domain.UserBastInfoPo;
import cn.mimik.finance.mapper.UserBastInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liugang on 2017/9/19.
 */
@Service
public class UserBastInfoService {

    @Autowired
    private UserBastInfoMapper userBastInfoMapper;

    public UserBastInfoPo selectUserBastInfo(UserBastInfoPo po){
       return userBastInfoMapper.selectOne(po);
    }

    public void updateUserBastInfo(UserBastInfoPo paramPo, UserBastInfoPo wherePo){

        userBastInfoMapper.update(paramPo, wherePo);
    }

    public void insertUserBastInfo(UserBastInfoPo po){
        userBastInfoMapper.insert(po);
    }
}
