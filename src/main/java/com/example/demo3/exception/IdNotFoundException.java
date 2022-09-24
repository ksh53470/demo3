package com.example.demo3.exception;

@SuppressWarnings("serial")
public class IdNotFoundException extends RuntimeException {
    public IdNotFoundException(String msg){ super(msg); }
}