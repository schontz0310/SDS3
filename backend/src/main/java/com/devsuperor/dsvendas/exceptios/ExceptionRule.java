package com.devsuperor.dsvendas.exceptios;

public class ExceptionRule extends RuntimeException {

    public ExceptionRule(String msg) {
    }

    public ExceptionRule(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionRule(Throwable cause) {
        super(cause);
    }

    public ExceptionRule(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
