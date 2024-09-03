package net.vrakin.med_salary.repository;

import net.vrakin.med_salary.domain.Department;
import net.vrakin.med_salary.domain.DepartmentIsProEleks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentIsProRepository extends JpaRepository<DepartmentIsProEleks, Long> {
    Optional<Department> findByName(String name);
}
