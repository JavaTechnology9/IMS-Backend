package com.primepro.ims.model;

import jakarta.persistence.*;

@Entity
@Table
public class CurrentStock {
    @Id
    @GeneratedValue
    @Column(name = "current_stock_id")
    private long currentStockId;
    private int quantity;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProducts() {
        return product;
    }

    public void setProducts(Product product) {
        this.product = product;
    }

    public PurchaseInfo getPurchaseInfo() {
        return purchaseInfo;
    }

    public void setPurchaseInfo(PurchaseInfo purchaseInfo) {
        this.purchaseInfo = purchaseInfo;
    }
}
