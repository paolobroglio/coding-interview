package com.paolobroglio.learn.codinginterview.datastructure.exception;

public class EmptyListException extends RuntimeException{

    public EmptyListException() {
        super("List is empty");
    }

    public EmptyListException(String message) {
        super(message);
    }

    public EmptyListException(String message, Throwable cause) {
        super(message, cause);
    }
}
