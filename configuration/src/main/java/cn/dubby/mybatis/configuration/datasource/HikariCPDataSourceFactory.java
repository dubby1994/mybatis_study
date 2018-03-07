package cn.dubby.mybatis.configuration.datasource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by yangzheng03 on 2018/3/6.
 */
public class HikariCPDataSourceFactory implements DataSourceFactory {

    private HikariConfig config;

    @Override
    public void setProperties(Properties props) {
        config = new HikariConfig(props);
    }

    @Override
    public DataSource getDataSource() {
        return new HikariDataSource(config);
    }
}
