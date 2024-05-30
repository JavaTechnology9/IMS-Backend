package com.primepro.ims.model;

import jakarta.persistence.*;

@Entity
@Table
public class Customers {
    @Id
    @GeneratedValue
    @Column(name = "customer_id")
    private long customerId;
    private String customerName;
    private String customerCode;
    private String location;
    private String phone;
    @OneToOne
    @JoinColumn(name = "sales_id")
    private SalesInfo salesInfo;
    public Customers(){

    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public SalesInfo getSalesInfo() {
        return salesInfo;
    }

    public void setSalesInfo(SalesInfo salesInfo) {
        this.salesInfo = salesInfo;
    }
}
