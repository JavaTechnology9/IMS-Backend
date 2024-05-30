package com.primepro.ims.model;

import jakarta.persistence.*;

@Entity
@Table
public class Users {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private long userId;
    private String fullName;
    private String location;
    private String phoneNumber;
    private String userName;
    private String password;
    private String userType;
    @OneToOne
    @JoinColumn(name = "sales_id")
    private SalesInfo salesInfo;

    public Users() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public SalesInfo getSalesInfo() {
        return salesInfo;
    }

    public void setSalesInfo(SalesInfo salesInfo) {
        this.salesInfo = salesInfo;
    }
}
