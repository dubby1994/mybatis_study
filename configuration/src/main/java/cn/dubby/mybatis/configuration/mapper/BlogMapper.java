package cn.dubby.mybatis.configuration.mapper;

import cn.dubby.mybatis.configuration.entity.Blog;

public interface BlogMapper {
    Blog selectBlog(long id);
    int insertBlog(Blog blog);
}
