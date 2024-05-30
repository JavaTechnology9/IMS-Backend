package com.primepro.ims.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class SalesInfo {
    @Id
    @GeneratedValue
    @Column(name = "sales_id")
    private long salesId;
    private LocalDateTime dateTime;
    private String productCode;
    private String customerCode;
    private int quantity;
    private double revenue;
    private String soldBy;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Products products;
    public SalesInfo(){

    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public long getSalesId() {
        return salesId;
    }

    public void setSalesId(long salesId) {
        this.salesId = salesId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public String getSoldBy() {
        return soldBy;
    }

    public void setSoldBy(String soldBy) {
        this.soldBy = soldBy;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }
}
