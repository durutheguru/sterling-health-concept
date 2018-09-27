package io.duru.projects.sterling.exception;

/**
 * created by dduru on 27/09/2018
 */
public class InvalidEntityException extends ApplicationException {


    public InvalidEntityException(String message) {
        super(message);
    }

    public InvalidEntityException(Throwable cause) {
        super(cause);
    }

    public InvalidEntityException(String message, Throwable cause) {
        super(message, cause);
    }



}