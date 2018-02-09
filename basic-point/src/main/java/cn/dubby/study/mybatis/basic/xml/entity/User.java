package cn.dubby.study.mybatis.basic.xml.entity;

/**
 * Created by yangzheng03 on 2018/2/9.
 */
public class User {

    private Long id;

    private String userName;

    private MobilePhone mobilePhone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public MobilePhone getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(MobilePhone mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", mobilePhone=" + mobilePhone +
                '}';
    }
}
