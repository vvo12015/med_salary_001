package net.vrakin.med_salary.service;

import net.vrakin.med_salary.dto.DepartmentDTO;
import net.vrakin.med_salary.entity.Department;
import net.vrakin.med_salary.entity.User;

import java.util.List;
import java.util.Optional;

public interface DepartmentService extends Service<Department>{
    Optional<Department> findByName(String name);
    Optional<Department> findByManager(User manager);
}
