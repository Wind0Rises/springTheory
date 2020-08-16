package com.liu.study.spring.mvc.controller.vo;

import java.io.Serializable;

/**
 * @desc
 * @author Liuweian
 * @version 1.0.0
 * @createTime 2020/5/26 8:37
 */
public class SecondTestMethodVo implements Serializable {

    private String username;

    private String password;

    private String like;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    @Override
    public String toString() {
        return "SecondTestMethodVo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", like='" + like + '\'' +
                '}';
    }
}
