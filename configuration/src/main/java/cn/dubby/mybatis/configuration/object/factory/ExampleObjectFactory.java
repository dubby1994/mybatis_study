package cn.dubby.mybatis.configuration.object.factory;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;
import java.util.Properties;

/**
 * Created by yangzheng03 on 2018/3/6.
 */
public class ExampleObjectFactory extends DefaultObjectFactory {

    private static final Logger logger = LoggerFactory.getLogger(ExampleObjectFactory.class);

    public <T> T create(Class<T> type) {
        logger.info("ExampleObjectFactory create a object, type is {}", type.getName());
        return super.create(type);
    }


    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        logger.info("ExampleObjectFactory create a object, type is {}", type.getName());
        return super.create(type, constructorArgTypes, constructorArgs);
    }

    public void setProperties(Properties properties) {
        super.setProperties(properties);
    }

    public <T> boolean isCollection(Class<T> type) {
        return Collection.class.isAssignableFrom(type);
    }

}
