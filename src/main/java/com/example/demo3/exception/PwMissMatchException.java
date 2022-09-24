package com.example.demo3.exception;

@SuppressWarnings("serial")
public class PwMissMatchException extends RuntimeException {
    public PwMissMatchException(String msg){ super(msg); }
}
