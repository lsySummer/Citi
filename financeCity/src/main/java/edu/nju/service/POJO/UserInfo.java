package edu.nju.service.POJO;

import java.sql.Timestamp;

/**
 * Created by Sun YuHao on 2016/7/25.
 */
public class UserInfo {
    private long id;
    private int state;
    private String account;
    private String userName;
    private String password;
    private Timestamp created_at;
    private Timestamp update_at;
    private String email;
    private String phone;
    private String secure_answer;
    private int choosed_questions;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Timestamp update_at) {
        this.update_at = update_at;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSecure_answer() {
        return secure_answer;
    }

    public void setSecure_answer(String secure_answer) {
        this.secure_answer = secure_answer;
    }

    public int getChoosed_questions() {
        return choosed_questions;
    }

    public void setChoosed_questions(int choosed_questions) {
        this.choosed_questions = choosed_questions;
    }
}
