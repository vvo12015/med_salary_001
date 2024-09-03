package net.vrakin.med_salary.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Map;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@Getter
public class ParametersMismatchException extends RuntimeException{

    private final String resourceName;
    private final Map<String, String> params;

    public ParametersMismatchException(String resourceName, Map<String, String> params) {
        super(String.format("%s's params does not match in the database. '%s'"
                , resourceName, params.toString()));
        this.resourceName = resourceName;
        this.params = params;
    }
}
