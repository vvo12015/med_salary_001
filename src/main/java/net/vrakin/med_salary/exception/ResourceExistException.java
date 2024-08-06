package net.vrakin.med_salary.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ResourceExistException extends RuntimeException{

    public ResourceExistException(String resourceName, String fieldValue) {
        super(String.format("Resource %s exist: '%s'", resourceName, fieldValue));
    }
}
