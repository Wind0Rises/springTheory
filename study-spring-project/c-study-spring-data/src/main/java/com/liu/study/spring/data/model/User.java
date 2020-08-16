package com.liu.study.spring.data.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Liuweian
 * @version 1.0.0
 * @desc
 * @createTime 2020/6/9 14:42
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private int userSeq;

    private String username;

    private String sex;

    private String password;

    private Date createTime;

    private Date updateTime;

    private int age;

    private String status;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getUserSeq() {
        return userSeq;
    }

    public void setUserSeq(int userSeq) {
        this.userSeq = userSeq;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "userSeq=" + userSeq +
                ", userName='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", age=" + age +
                ", status='" + status + '\'' +
                '}';
    }
}
