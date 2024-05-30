package com.primepro.ims.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table
public class PurchaseInfo {
    @Id
    @GeneratedValue
    @Column(name = "purchase_id")
    private long purchaseId;
    private String supplierCode;
    private String productCode;
    private LocalDateTime purchaseDate;
    private int quantity;
    private double price;
    @OneToOne
    @JoinColumn(name = "supplier_id")
    private Suppliers suppliers;

    public PurchaseInfo() {
    }

    public long getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(long purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Suppliers getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Suppliers suppliers) {
        this.suppliers = suppliers;
    }
}
