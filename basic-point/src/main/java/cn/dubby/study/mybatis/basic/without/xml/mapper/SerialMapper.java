package cn.dubby.study.mybatis.basic.without.xml.mapper;

import cn.dubby.study.mybatis.basic.without.xml.entity.Serial;
import org.apache.ibatis.annotations.Select;

public interface SerialMapper {
    @Select("SELECT * FROM serial WHERE id = #{id}")
    Serial selectSerial(long id);
}
