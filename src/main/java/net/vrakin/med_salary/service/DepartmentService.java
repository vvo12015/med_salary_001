package net.vrakin.med_salary.service;

import net.vrakin.med_salary.dto.DepartmentDTO;
import net.vrakin.med_salary.entity.Department;

import java.util.List;

public interface DepartmentService extends Service<Department>{
    List<Department> findByName(String name);
}
