package ru.netology.hw_authorizationservice.exception;

public class InvalidCredentials extends RuntimeException{
    public InvalidCredentials(String msg) {
        super(msg);
    }
}
