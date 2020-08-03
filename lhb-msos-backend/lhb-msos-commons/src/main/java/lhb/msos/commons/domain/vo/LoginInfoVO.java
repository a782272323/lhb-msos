package lhb.msos.commons.domain.vo;

import java.io.Serializable;

/**
 * @Description  后台管理网站登录信息实体类
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/8/3
 * @time 16:39
 */
public class LoginInfoVO implements Serializable {


    private static final long serialVersionUID = -90000027L;

    /**
     * 用户名
     */
    private String name;
    /**
     * 头像,使用七牛
     */
    private String avatar;
    /**
     * 权限，可以写死。
     */
    private String roles;

    @Override
    public String toString() {
        return "LoginInfoVO{" +
                "name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", roles='" + roles + '\'' +
                '}';
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}