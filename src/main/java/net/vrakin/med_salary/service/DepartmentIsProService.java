package net.vrakin.med_salary.service;

import net.vrakin.med_salary.domain.Department;
import net.vrakin.med_salary.domain.mapping.users.User;

import java.util.Optional;

public interface DepartmentIsProService extends Service<Department>{
    Optional<Department> findByName(String name);
    Optional<Department> findByManager(User manager);
}
