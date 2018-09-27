package io.duru.projects.sterling.exception;

/**
 * created by dduru on 27/09/2018
 */
public class PartnerSetupException extends EntitySetupException {


    public PartnerSetupException(String message) {
        super(message);
    }


    public PartnerSetupException(Throwable cause) {
        super(cause);
    }


    public PartnerSetupException(String message, Throwable cause) {
        super(message, cause);
    }


}