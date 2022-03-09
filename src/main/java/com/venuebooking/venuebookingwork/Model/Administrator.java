package com.venuebooking.venuebookingwork.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Administrator {

    //管理员ID
    @Id
    @GeneratedValue
    @Column(unique = true)
    private Long superID;
    //管理员登录用账号
    @Column(unique = true)
    private String superName;
    //管理员密码
    private String password;

    public Administrator() {
    }

    public Administrator(String superName, String password) {
        this.superName = superName;
        this.password = password;
    }

    public Long getSuperID() {
        return superID;
    }

    public void setSuperID(Long superID) {
        this.superID = superID;
    }

    public String getSuperName() {
        return superName;
    }

    public void setSuperName(String superName) {
        this.superName = superName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
