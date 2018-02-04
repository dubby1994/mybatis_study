package cn.dubby.study.mybatis.basic.xml;

import cn.dubby.study.mybatis.basic.xml.entity.Blog;
import cn.dubby.study.mybatis.basic.xml.mapper.BlogMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        try {
            Blog blog1 = session.selectOne("cn.dubby.study.mybatis.basic.xml.mapper.BlogMapper.selectBlog", 1);
            System.out.println(blog1);

            BlogMapper mapper = session.getMapper(BlogMapper.class);
            Blog blog2 = mapper.selectBlog(1);
            System.out.println(blog2);
        } finally {
            session.close();
        }
    }

}
