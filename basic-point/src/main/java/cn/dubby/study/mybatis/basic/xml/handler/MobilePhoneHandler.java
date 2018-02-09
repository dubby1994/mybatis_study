package cn.dubby.study.mybatis.basic.xml.handler;

import cn.dubby.study.mybatis.basic.xml.entity.MobilePhone;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by yangzheng03 on 2018/2/9.
 */
@MappedJdbcTypes(JdbcType.VARCHAR)
public class MobilePhoneHandler extends BaseTypeHandler<MobilePhone> {

    public void setNonNullParameter(PreparedStatement ps, int i, MobilePhone parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.toString());
    }

    public MobilePhone getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return convert(rs.getString(columnName));
    }

    public MobilePhone getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return convert(rs.getString(columnIndex));
    }

    public MobilePhone getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return convert(cs.getString(columnIndex));
    }

    private MobilePhone convert(String mobileInDB) {
        if (mobileInDB == null || mobileInDB.trim().length() == 0)
            return null;

        String[] mobilePair = mobileInDB.split("_");
        if (mobilePair.length != 2) {
            throw new IllegalArgumentException("mobile phone must be consist of countryCode and mobileNo.");
        }
        return new MobilePhone(mobilePair[0], mobilePair[1]);
    }
}
