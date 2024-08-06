package net.vrakin.med_salary.repository;

import net.vrakin.med_salary.entity.SecurityUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SecurityUserRepository extends JpaRepository<SecurityUser, Long> {
    Optional<SecurityUser> findByLogin(String login);
    Optional<SecurityUser> findByLoginOrEmail(String login, String email);
}
