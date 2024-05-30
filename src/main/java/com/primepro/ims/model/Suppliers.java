package com.primepro.ims.model;

import jakarta.persistence.*;

@Entity
@Table
public class Suppliers {
    @Id
    @GeneratedValue
    @Column(name = "supplier_id")
    private long supplierId;
    private String supplierName;
    private String supplierCode;
    private String location;
    private String mobileNumber;

}
