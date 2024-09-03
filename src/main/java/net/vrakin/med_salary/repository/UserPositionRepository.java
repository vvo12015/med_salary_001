package net.vrakin.med_salary.repository;

import net.vrakin.med_salary.domain.UserPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserPositionRepository extends JpaRepository<UserPosition, Long> {
    Optional<UserPosition> findByName(String name);
}
