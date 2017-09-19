package cn.mimik.finance.service;

import cn.mimik.finance.domain.UserAcctListPo;
import cn.mimik.finance.mapper.UserAcctListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liugang on 2017/9/18.
 */
@Service
public class UserAcctListService {

    @Autowired
    private UserAcctListMapper userAcctListMapper;

    public List<UserAcctListPo> getUserAcctList(UserAcctListPo po){
        return userAcctListMapper.selectList(po);
    }


    public void addUserAcctList(UserAcctListPo po){
        userAcctListMapper.insert(po);
    }

    public void deleteUserAcctList(UserAcctListPo po){
        userAcctListMapper.delete(po);
    }
}
