package io.duru.projects.sterling.exception;

/**
 * created by dduru on 27/09/2018
 */
public class EntityPersistenceException extends ApplicationException {


    public EntityPersistenceException(String message) {
        super(message);
    }

    public EntityPersistenceException(Throwable cause) {
        super(cause);
    }

    public EntityPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }


}