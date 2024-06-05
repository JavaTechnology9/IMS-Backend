package com.primepro.ims.model;

import jakarta.persistence.*;

@Entity
@Table
public class Supplier {
    @Id
    @GeneratedValue
    @Column(name = "supplier_id")
    private long supplierId;
    private String supplierName;
    private String supplierCode;
    private String address;
    private String mobileNumber;
    private String email;

    public Supplier(long supplierId, String supplierName, String supplierCode, String address, String mobileNumber, String email) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.supplierCode = supplierCode;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

    public Supplier() {

    }

    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
