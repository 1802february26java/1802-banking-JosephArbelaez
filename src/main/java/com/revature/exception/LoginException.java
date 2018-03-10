package com.revature.exception;

public class LoginException extends Exception{
	    public LoginException(){}
	    
	    public LoginException(String message){
	    	super(message);
	    }
	    
	    public LoginException(String message, Throwable cause){
	    	super(message, cause);
	    }
}
