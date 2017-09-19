package cn.mimik.finance.mapper;

import java.util.List;

/**
 * Created by liugang on 2017/9/17.
 */
public interface BaseMapper<T> {

    List selectList(T t);

    T selectOne(T t);

    void delete(T t);

    void update(Object obj);

    void update(T setParam, T whereParam);

   void insert(T t);
}
