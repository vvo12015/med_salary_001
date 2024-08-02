package net.vrakin.med_salary.repository;

import net.vrakin.med_salary.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);

    List<User> findBySpeciality(String specialty);

    List<User> findByName(String name);
}
