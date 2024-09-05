package net.vrakin.med_salary.repository;

import net.vrakin.med_salary.domain.Department;
import net.vrakin.med_salary.domain.Role;
import net.vrakin.med_salary.domain.mapping.users.AbstractUser;
import net.vrakin.med_salary.domain.mapping.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AbstractUser, Long> {
    Optional<User> findByName(String name);

    Optional<User> findByIPN(String IPN);
}
