package net.vrakin.med_salary.exception;

import lombok.Getter;

@Getter
public class ReflectionIllegalAccessException extends IllegalAccessException{

    private final String resourceName;

    public ReflectionIllegalAccessException(String resourceName) {
        this.resourceName = resourceName;
    }
}
