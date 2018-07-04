package com.ex.demo.bean;

import javax.persistence.*;
import java.util.Date;

@Entity  // 添加jpa实例注解
@Table
public class UserLog {
    @Id // 主键
    @GeneratedValue
    private Integer id;

    @Column
    private Date createTime; // jpa 命名对应数据库字段为：create_time

    @Column
    private String userName; // 数据库：user_name

    @Column
    private String userIp;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    @Override
    public String toString() {
        return "UserLog [id=" + id + ", createTime=" + createTime + ", userName=" + userName + ", userIp=" + userIp + "]";
    }
}