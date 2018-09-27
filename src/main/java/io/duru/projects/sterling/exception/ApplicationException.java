package io.duru.projects.sterling.exception;

/**
 * created by dduru on 27/09/2018
 */
public class ApplicationException extends Exception {


    public ApplicationException(String message) {
        super(message);
    }


    public ApplicationException(Throwable cause) {
        super(cause);
    }


    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }


}