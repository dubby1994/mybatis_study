package cn.dubby.study.mybatis.basic.xml.mapper;

import cn.dubby.study.mybatis.basic.xml.entity.Blog;

public interface BlogMapper {
    Blog selectBlog(long id);
}
