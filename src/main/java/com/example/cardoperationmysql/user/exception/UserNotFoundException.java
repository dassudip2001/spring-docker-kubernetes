package com.example.cardoperationmysql.user.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(int id){
        super("could not found"+id);
    }
}
