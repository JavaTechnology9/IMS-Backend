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
    private String productName;
    private String customerCode;
    private int quantity;
    private double sellPrice;
    private String soldBy;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
    public SalesInfo(){

    }

    public long getSalesId() {
        return salesId;
    }

    public void setSalesId(long salesId) {
        this.salesId = salesId;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getSoldBy() {
        return soldBy;
    }

    public void setSoldBy(String soldBy) {
        this.soldBy = soldBy;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
