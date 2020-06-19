package com.lty.learn.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface GetDao {

    @Select(" select * from  base_user_car   where username = 'xxx' ")
    Map getUser();


}
