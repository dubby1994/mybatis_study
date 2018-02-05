package cn.dubby.study.mybatis.basic.without.xml;

import cn.dubby.study.mybatis.basic.without.xml.entity.Serial;
import cn.dubby.study.mybatis.basic.without.xml.mapper.SerialMapper;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;

public class Main {

    public static void main(String[] args) {
        DataSource dataSource = new UnpooledDataSource("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/mybatis_study?useUnicode=true&characterEncoding=UTF-8&useLegacyDatetimeCode=false&serverTimezone=UTC", "test", "123456");
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(SerialMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        SqlSession session = sqlSessionFactory.openSession();
        try {
            Serial serial1 = session.selectOne("cn.dubby.study.mybatis.basic.without.xml.mapper.SerialMapper.selectSerial", 1);
            System.out.println(serial1);

            SerialMapper mapper = session.getMapper(SerialMapper.class);
            Serial serial2 = mapper.selectSerial(1);
            System.out.println(serial2);
        } finally {
            session.close();
        }
    }

}
