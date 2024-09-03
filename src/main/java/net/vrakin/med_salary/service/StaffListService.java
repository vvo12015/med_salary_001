package net.vrakin.med_salary.service;

import net.vrakin.med_salary.domain.UserPosition;
import net.vrakin.med_salary.domain.mapping.department.MapDepartment;
import net.vrakin.med_salary.domain.mapping.users.StaffList;

import java.util.List;

public interface StaffListService extends Service<StaffList> {
    List<StaffList> findByUserPositionDepartment(UserPosition userPosition, MapDepartment mapDepartment);
}
