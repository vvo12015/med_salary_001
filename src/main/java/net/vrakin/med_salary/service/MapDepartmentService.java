package net.vrakin.med_salary.service;

import net.vrakin.med_salary.domain.Department;
import net.vrakin.med_salary.domain.mapping.department.MapDepartment;
import net.vrakin.med_salary.domain.mapping.department.MapDepartmentUser;

import java.util.Optional;

public interface MapDepartmentService extends Service<MapDepartment> {
    Optional<MapDepartmentUser> findByDepartmentIsProIdAndUserId(String departmentIsProId, String userId);
}
