package com.primepro.ims.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class Login {
    @Id
    @GeneratedValue
    @Column(name = "login_id")
    private long id;
    private String username;
    private String password;

    private LocalDateTime loginInTime;

    private LocalDateTime loginOutTime;

    public String getUsername() {
        return username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public LocalDateTime getLoginInTime() {
        return loginInTime;
    }

    public void setLoginInTime(LocalDateTime loginInTime) {
        this.loginInTime = loginInTime;
    }

    public LocalDateTime getLoginOutTime() {
        return loginOutTime;
    }

    public void setLoginOutTime(LocalDateTime loginOutTime) {
        this.loginOutTime = loginOutTime;
    }
}
