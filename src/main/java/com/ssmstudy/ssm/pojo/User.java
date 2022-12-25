package com.ssmstudy.ssm.pojo;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable {
    private Integer id;

    private String name;

    private String username;

    private String password;

    private String email;

    private Integer age;

    private Date registerTime;

    private Date lastModificationTime;

    private Integer dept;
    private String token;

    private String userphoto;


    private String gender;


    public String getUserphoto() {
        return userphoto;
    }

    public void setUserphoto(String userphoto) {
        this.userphoto = userphoto;
    }




    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getLastModificationTime() {
        return lastModificationTime;
    }

    public void setLastModificationTime(Date lastModificationTime) {
        this.lastModificationTime = lastModificationTime;
    }



    public Integer getDept() {
        return dept;
    }

    public void setDept(Integer dept) {
        this.dept = dept;
    }





    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", registerTime=" + registerTime +
                ", lastModificationTime=" + lastModificationTime +
                ", dept=" + dept +
                ", token='" + token + '\'' +
                ", userphoto='" + userphoto + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public User(Integer id, String name, String username, String password, String email, Integer age, Date registerTime, Date lastModificationTime, Integer dept, String userphoto, String gender) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
        this.registerTime = registerTime;
        this.lastModificationTime = lastModificationTime;
        this.dept = dept;
        this.userphoto = userphoto;
        this.gender = gender;
    }
    public User(Integer id, String name, String username, String password, String email, Integer age, Date registerTime, Date lastModificationTime, Integer dept, String token, String userphoto, String gender) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
        this.registerTime = registerTime;
        this.lastModificationTime = lastModificationTime;
        this.dept = dept;
        this.token = token;
        this.userphoto = userphoto;
        this.gender = gender;
    }
}
