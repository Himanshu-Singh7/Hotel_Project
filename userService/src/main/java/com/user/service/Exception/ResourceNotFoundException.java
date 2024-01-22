package com.user.service.Exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(){
        super("Resource is not found on server !!");
    }

    public ResourceNotFoundException(String message){
        super(message);
    }
}
