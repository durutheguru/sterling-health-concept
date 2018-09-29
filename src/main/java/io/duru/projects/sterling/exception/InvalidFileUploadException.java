package io.duru.projects.sterling.exception;

/**
 * created by dduru on 29/09/2018
 */
public class InvalidFileUploadException extends ApplicationException {


    public InvalidFileUploadException(String message) {
        super(message);
    }

    public InvalidFileUploadException(Throwable cause) {
        super(cause);
    }

    public InvalidFileUploadException(String message, Throwable cause) {
        super(message, cause);
    }


}