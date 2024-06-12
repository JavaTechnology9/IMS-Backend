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

    private LocalDateTime loginTime;

    private LocalDateTime logoutTime;

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

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public LocalDateTime getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(LocalDateTime logoutTime) {
        this.logoutTime = logoutTime;
    }
}
