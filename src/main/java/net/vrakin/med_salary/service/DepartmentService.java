package net.vrakin.med_salary.service;

import net.vrakin.med_salary.dto.DepartmentDTO;
import net.vrakin.med_salary.dto.RoleDTO;

import java.util.List;

public interface DepartmentService extends Service<DepartmentDTO>{
    List<DepartmentDTO> findByName(String name);
}
