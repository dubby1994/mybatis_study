package cn.dubby.mybatis.configuration;

import cn.dubby.mybatis.configuration.entity.Blog;
import cn.dubby.mybatis.configuration.entity.Category;
import cn.dubby.mybatis.configuration.entity.User;
import cn.dubby.mybatis.configuration.mapper.BlogMapper;
import cn.dubby.mybatis.configuration.mapper.CategoryMapper;
import cn.dubby.mybatis.configuration.mapper.UserMapper;
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

        testBlog(sqlSessionFactory);
    }

    private static void testCategory(SqlSessionFactory sqlSessionFactory) throws IOException {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            CategoryMapper categoryMapper = session.getMapper(CategoryMapper.class);
            Category category = categoryMapper.selectCategory(1);
            System.out.println(category);

            category = categoryMapper.selectCategory(2);
            System.out.println(category);
        } finally {
            session.close();
        }
    }

    private static void testBlog(SqlSessionFactory sqlSessionFactory) throws IOException {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            BlogMapper mapper = session.getMapper(BlogMapper.class);
            Blog blog = mapper.selectBlog(1);
            System.out.println(blog);

            for (int i = 0; i < 10; ++i) {
                blog = mapper.selectBlog(1);
                System.out.println(blog);
            }

            Blog newBlog = new Blog();
            newBlog.setTitle("测试title");
            newBlog.setContent("测试content");
            mapper.insertBlog(newBlog);
            System.out.println(newBlog.getId());
            session.commit();
        } finally {
            session.close();
        }
    }

}
