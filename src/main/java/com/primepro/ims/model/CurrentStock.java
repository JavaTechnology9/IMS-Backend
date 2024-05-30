package com.primepro.ims.model;

import jakarta.persistence.*;

@Entity
@Table
public class CurrentStock {
    @Id
    @GeneratedValue
    @Column(name = "current_stock_id")
    private long currentStockId;
    private String productCode;
    private int quantity;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Products products;
    @OneToOne
    @JoinColumn(name = "purchase_id")
    private PurchaseInfo purchaseInfo;

    public CurrentStock() {
    }

    public long getCurrentStockId() {
        return currentStockId;
    }

    public void setCurrentStockId(long currentStockId) {
        this.currentStockId = currentStockId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Products getProducts() {
        return products;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public PurchaseInfo getPurchaseInfo() {
        return purchaseInfo;
    }

    public void setPurchaseInfo(PurchaseInfo purchaseInfo) {
        this.purchaseInfo = purchaseInfo;
    }
}
