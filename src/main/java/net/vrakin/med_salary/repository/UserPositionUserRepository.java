package net.vrakin.med_salary.repository;

import net.vrakin.med_salary.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserPositionUserRepository extends JpaRepository<UserPositionUser, Long> {

    @Query("SELECT upu FROM UserPositionUser upu JOIN upu.user u WHERE u = :user")
    List<UserPositionUser> findByUser(@Param("user") User user);

    @Query("SELECT upu FROM UserPositionUser upu JOIN upu.userPosition up WHERE up = :userPosition")
    List<UserPositionUser> findByUserPosition(@Param("userPosition") UserPosition user);

    List<UserPositionUser> findByEmploymentBetween(Float lower, Float higher);
}
