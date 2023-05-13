package ru.netology.hw_authorizationservice.exception;

public class UnauthorizedUser extends RuntimeException{
    public UnauthorizedUser (String msg) {
        super(msg);
    }
}
