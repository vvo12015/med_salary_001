package net.vrakin.med_salary.repository;

import net.vrakin.med_salary.domain.Department;
import net.vrakin.med_salary.domain.mapping.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByName(String name);
    Optional<Department> findByManager(User manager);
}
