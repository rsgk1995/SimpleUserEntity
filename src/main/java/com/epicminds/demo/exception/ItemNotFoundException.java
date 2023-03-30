package com.epicminds.demo.exception;

/**
 * @author Sidharth
 */
public class ItemNotFoundException extends RuntimeException{
    public ItemNotFoundException(String message){
        super(message);
    }
}
