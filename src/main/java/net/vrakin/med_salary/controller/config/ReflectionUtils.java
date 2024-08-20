package net.vrakin.med_salary.controller.config;

import net.vrakin.med_salary.exception.ReflectionIllegalAccessException;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ReflectionUtils {

    public static Map<String, Object> getFields(Object obj) throws ReflectionIllegalAccessException {
        Map<String, Object> fields = new HashMap<>();
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                fields.put(field.getName(), field.get(obj));
            } catch (IllegalAccessException e) {
                throw new ReflectionIllegalAccessException(obj.toString());
            }
        }
        return fields;
    }
}
