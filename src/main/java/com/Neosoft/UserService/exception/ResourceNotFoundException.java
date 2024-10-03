package com.Neosoft.UserService.exception;

public class ResourceNotFoundException extends RuntimeException{

    // Default Constructor
    public ResourceNotFoundException()
    {
        super("Resource Not found on Server...");
    }

    // Parametrized Constructor
    public ResourceNotFoundException(String message)
    {
        super(message);
    }
}
