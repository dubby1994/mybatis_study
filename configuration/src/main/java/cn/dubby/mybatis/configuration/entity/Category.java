package cn.dubby.mybatis.configuration.entity;

import cn.dubby.mybatis.configuration.enums.CategoryEnum;

/**
 * Created by yangzheng03 on 2018/3/7.
 */
public class Category {

    private Integer id;

    private CategoryEnum category1;

    private CategoryEnum category2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CategoryEnum getCategory1() {
        return category1;
    }

    public void setCategory1(CategoryEnum category1) {
        this.category1 = category1;
    }

    public CategoryEnum getCategory2() {
        return category2;
    }

    public void setCategory2(CategoryEnum category2) {
        this.category2 = category2;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", category1=" + category1 +
                ", category2=" + category2 +
                '}';
    }
}
