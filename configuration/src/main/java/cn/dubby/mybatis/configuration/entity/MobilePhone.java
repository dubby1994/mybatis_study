package cn.dubby.mybatis.configuration.entity;

/**
 * Created by yangzheng03 on 2018/2/9.
 */
public class MobilePhone {

    private static final String DEFAULT_COUNTRY_CODE = "86";

    private String countryCode;

    private String mobile;

    public MobilePhone(String mobile) {
        this(DEFAULT_COUNTRY_CODE, mobile);
    }

    public MobilePhone(String countryCode, String mobile) {
        this.countryCode = countryCode;
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "'" + countryCode + "_" + mobile + "'";
    }

}
