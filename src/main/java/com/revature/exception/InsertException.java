package com.revature.exception;

public class InsertException extends Exception{
	public InsertException(){}
	
    public InsertException(String message){
    	super(message);
    }
    
    public InsertException(String message, Throwable cause){
    	super(message, cause);
    }
}
