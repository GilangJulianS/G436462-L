package com.itb.hmif.ganeshalife.model;

/**
 * Created by Yanfa on 3/10/2016.
 */
public class User {

    private String userId;
    private String username;
    private String realname;
    private String password;
    private String email;
    private String token;
    private int value;
    private int userUrgency;

    public User(String userId, String username, String realname, String email, int value) {
        this.userId = userId;
        this.username = username;
        this.realname = realname;
        this.email = email;
        this.value = value;
    }

    public User(String userId, String username, String realname, String password, String email, int value) {
        this.userId = userId;
        this.username = username;
        this.realname = realname;
        this.password = password;
        this.email = email;
        this.value = value;
    }

    public User(String username, String realname, String email, int value) {
        this.username = username;
        this.realname = realname;
        this.email = email;
        this.value = value;
    }



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
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

    public int getUserUrgency() {
        return userUrgency;
    }

    public void setUserUrgency(int userUrgency) {
        this.userUrgency = userUrgency;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
