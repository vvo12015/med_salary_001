package net.vrakin.med_salary.repository;

import net.vrakin.med_salary.domain.mapping.department.MapDepartment;
import net.vrakin.med_salary.domain.mapping.department.MapDepartmentUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MapDepartmentRepository extends JpaRepository<MapDepartment, Long> {
    List<MapDepartment> findByDepartmentIsProId(String departmentIsProId);
    Optional<MapDepartmentUser> findByDepartmentIsProIdAndUserId(String departmentIsProId, String userId);
}
