package com.venuebooking.venuebookingwork.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    //UID
    @Id
    @GeneratedValue
    @Column(unique = true)
    private Long uid;
    //登录用用户名
    @Column(unique = true)
    private String userName;
    //显示昵称
    private String nickName = "alien";
    //密码
    private String password;
    //注册时间
    private String regTime;


    public User() {
    }

    public User(String userName, String nickName, String password, String regTime) {
        this.userName = userName;
        this.nickName = nickName;
        this.password = password;
        this.regTime = regTime;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }
}
