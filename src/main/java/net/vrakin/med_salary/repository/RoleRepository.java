package net.vrakin.med_salary.repository;

import net.vrakin.med_salary.entity.Role;
import net.vrakin.med_salary.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    List<Role> findByName(String name);
}
