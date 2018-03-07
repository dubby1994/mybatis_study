package cn.dubby.mybatis.configuration.plugin;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * Created by yangzheng03 on 2018/3/7.
 */
@Intercepts({@Signature(
        type = Executor.class,
        method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class ExamplePlugin implements Interceptor {

    private Logger logger = LoggerFactory.getLogger(ExamplePlugin.class);

    public Object intercept(Invocation invocation) throws Throwable {
        logger.info("====intercept start====");
        logger.info("参数:{}", invocation.getArgs());
        Object result = invocation.proceed();
        logger.info("结果:{}", result);
        logger.info("====intercept complete====");
        return result;
    }

    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    public void setProperties(Properties properties) {
    }
}
