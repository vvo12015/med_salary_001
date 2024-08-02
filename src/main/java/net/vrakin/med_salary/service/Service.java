package net.vrakin.med_salary.service;

import java.util.List;
import java.util.Optional;

public interface Service<T> {
    Optional<T> findById(Long id);
    List<T> findByName(String name);
    List<T> findAll();
    T save(T t);
    void delete(T t);
    void deleteById(Long id);
    void deleteAllById(List<Long> ids);
}
