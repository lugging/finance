package cn.mimik.finance.mapper;

import cn.mimik.finance.domain.UserPo;

import java.util.List;

/**
 * Created by liugang on 2017/9/13.
 */
public interface UserMapper {

    List<UserPo> selectList();
}
