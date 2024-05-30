package com.primepro.ims.model;

import jakarta.persistence.*;

@Entity
@Table
public class Registration {
    @Id
    @GeneratedValue
    @Column(name = "registration_id")
    private long id;
    private String username;
    private String password;
    private String mobileNo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }
}
