package net.vrakin.med_salary.repository;

import net.vrakin.med_salary.domain.*;
import net.vrakin.med_salary.domain.mapping.users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPositionUserRepository extends JpaRepository<StaffList, Long> {

    @Query("SELECT upu FROM UserPositionUser upu JOIN upu.user u WHERE u = :user")
    List<StaffList> findByUser(@Param("user") User user);

    @Query("SELECT upu FROM UserPositionUser upu JOIN upu.userPosition up WHERE up = :userPosition")
    List<StaffList> findByUserPosition(@Param("userPosition") UserPosition user);

    List<StaffList> findByEmploymentBetween(Float lower, Float higher);
}
