package net.vrakin.med_salary.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class IdMismatchException extends RuntimeException{

    public IdMismatchException(String resourceName, String idURL, String idRequestBody) {
        super(String.format("%s's ID does not match in the URL. '%s' != '%s'"
                , resourceName, idURL, idRequestBody));
    }
}
