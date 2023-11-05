package com.example.lattice_Assignment.Exception;

public class EntityAreadyExistsException extends RuntimeException{
    public EntityAreadyExistsException(String message){
        super(message);
    }
}
