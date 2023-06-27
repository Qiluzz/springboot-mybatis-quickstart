package com.qlz.mapper;

import com.qlz.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper //在运行时，会自动生成连接接口的实现类对象（代理对象），并且将该对象交给IOC容器管理
public interface UserMapper {
    // 查询所有用户信息
    @Select("select * from user")
    public List<User> list();
}
