package com.primepro.ims.exception;

public class PurchaseException extends Exception{
    private String purchaseMessage;

    public PurchaseException(){
        super();
    }
    public PurchaseException(String purchaseMessage){
        super(purchaseMessage);
        this.purchaseMessage =purchaseMessage;
    }
}
