package com.primepro.ims.exception;

public class SupplierNotFoundException extends PurchaseException{
    private String supplierMessage;

    public SupplierNotFoundException(){
        super();
    }
    public SupplierNotFoundException(String supplierMessage){
        super(supplierMessage);
        this.supplierMessage=supplierMessage;
    }
}
