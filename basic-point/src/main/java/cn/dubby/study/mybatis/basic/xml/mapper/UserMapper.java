package cn.dubby.study.mybatis.basic.xml.mapper;

import cn.dubby.study.mybatis.basic.xml.entity.User;

public interface UserMapper {
    User selectUser(long id);
}
