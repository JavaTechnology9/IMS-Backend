package com.primepro.ims.exception;

public class EmailException extends Exception{
    private String message;

    public EmailException(){
        super();
    }
    public EmailException(String message){
        super(message);
        this.message=message;
    }
}
