package com.primepro.ims.exception;

public class ProductException extends PurchaseException{
    private String productMessage;

    public ProductException(){
        super();
    }
    public ProductException(String productMessage){
        super(productMessage);
        this.productMessage =productMessage;
    }
}
