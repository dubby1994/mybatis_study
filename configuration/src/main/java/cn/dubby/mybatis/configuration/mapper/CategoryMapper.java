package cn.dubby.mybatis.configuration.mapper;

import cn.dubby.mybatis.configuration.entity.Category;

/**
 * Created by yangzheng03 on 2018/3/7.
 */
public interface CategoryMapper {

    Category selectCategory(int id);

}
