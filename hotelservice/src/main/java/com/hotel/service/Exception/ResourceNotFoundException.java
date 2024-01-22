package com.hotel.service.Exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(){

        super("Resource is not found!!");
    }

    public ResourceNotFoundException(String s){
        super(s);
    }
}
