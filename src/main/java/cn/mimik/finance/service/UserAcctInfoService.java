package cn.mimik.finance.service;

import cn.mimik.finance.domain.UserAcctInfoPo;
import cn.mimik.finance.mapper.UserAcctInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liugang on 2017/9/18.
 */
@Service
public class UserAcctInfoService {

    @Autowired
    private UserAcctInfoMapper userAcctInfoMapper;

    public void insertUserAcctInfo(UserAcctInfoPo po){
        userAcctInfoMapper.insert(po);
    }


    public UserAcctInfoPo selectUserAcctInfo(UserAcctInfoPo po){
        return userAcctInfoMapper.selectOne(po);
    }

    /**
     * 增加账户金额
     */
    public void updateUserAcctInfo(UserAcctInfoPo paramPo){
        userAcctInfoMapper.update(paramPo);
    }
}
