package net.vrakin.med_salary.repository;

import net.vrakin.med_salary.domain.UserPosition;
import net.vrakin.med_salary.domain.mapping.department.MapDepartment;
import net.vrakin.med_salary.domain.mapping.users.StaffList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffListRepository extends JpaRepository<StaffList, Long> {
    List<StaffList> findByUserPositionDepartment(UserPosition userPosition, MapDepartment mapDepartment);
}
