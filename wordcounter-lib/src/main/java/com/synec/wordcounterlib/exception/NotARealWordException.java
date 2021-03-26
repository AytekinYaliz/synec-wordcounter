package com.synec.wordcounterlib.exception;


public class NotARealWordException extends RuntimeException {

    public NotARealWordException(String message) {
        super(message);
    }
}
