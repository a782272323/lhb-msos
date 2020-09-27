package lhb.msos.commons.domain.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description  后台管理系统用户表实体类
 * @author Herbie Leung(梁鸿斌)
 * @date 2020/9/27
 * @time 22:34
 */
public class SysManagerUserEntity implements Serializable {

    private static final long serialVersionUID = -90000177L;
    /**
     * id
     */
    private Long id;
    /**
     * 管理网站用户真实姓名
     */
    private String name;
    /**
     * 手机号码
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 电话区号
     */
    private String areaCode;
    /**
     * 账户状态
     * 0-禁用
     * 1-启用
     */
    private Integer status;
    /**
     * 联系地址
     */
    private String address;
    /**
     * 登录系统的用户名
     */
    private String username;
    /**
     * 用户所属系统类型，这里的用户是后台管理网站的用户，写死为2
     */
    private Integer sysType;
    /**
     * 用户头像,若用户不上传则用默认的3个头像
     */
    private String userIcon;
    /**
     * 密码(若用短信或者邮箱登录则不需要)
     */
    private String password;
    /**
     * 备注
     */
    private String remark;
    /**
     * 创建时间
     */
    private Date created;
    /**
     * 更新时间
     */
    private Date updated;

    @Override
    public String toString() {
        return "SysManagerUserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", areaCode='" + areaCode + '\'' +
                ", status=" + status +
                ", address='" + address + '\'' +
                ", username='" + username + '\'' +
                ", sysType=" + sysType +
                ", userIcon='" + userIcon + '\'' +
                ", password='" + password + '\'' +
                ", remark='" + remark + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getSysType() {
        return sysType;
    }

    public void setSysType(Integer sysType) {
        this.sysType = sysType;
    }

    public String getUserIcon() {
        return userIcon;
    }

    public void setUserIcon(String userIcon) {
        this.userIcon = userIcon;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
