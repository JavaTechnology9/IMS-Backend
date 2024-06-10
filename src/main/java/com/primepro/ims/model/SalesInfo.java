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
    private int quantity;
    private String revenue;
    private String soldBy;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
