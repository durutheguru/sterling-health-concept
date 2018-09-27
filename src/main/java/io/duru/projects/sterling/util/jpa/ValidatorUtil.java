package io.duru.projects.sterling.util.jpa;

import io.duru.projects.sterling.exception.InvalidEntityException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * created by dduru on 27/09/2018
 */
public class ValidatorUtil {


    static Logger log = LoggerFactory.getLogger(ValidatorUtil.class);


    private static <T> Set<ConstraintViolation<T>> getConstraintViolations(T item) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        return validator.validate(item);
    }


    public static <T> void validate(T item) throws InvalidEntityException {
        Set<ConstraintViolation<T>> violations = getConstraintViolations(item);
        if (!violations.isEmpty()){
            throw new InvalidEntityException(violations.iterator().next().getMessage());
        }
    }


    public static <T> boolean isValid(T item) {
        Set<ConstraintViolation<T>> violations = getConstraintViolations(item);
        return violations.isEmpty();
    }


    public static <T> void testValid(T item) {
        assert isValid(item);
    }


}