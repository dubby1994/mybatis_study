package cn.dubby.mybatis.configuration.mapper;

import cn.dubby.mybatis.configuration.entity.User;

public interface UserMapper {
    User selectUser(long id);
}
