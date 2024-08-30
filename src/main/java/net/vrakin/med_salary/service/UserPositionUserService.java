package net.vrakin.med_salary.service;

import net.vrakin.med_salary.entity.*;

import java.util.List;

public interface UserPositionUserService extends Service<StaffList> {

    List<StaffList> findByUser(User user);

    List<StaffList> findByUserPosition(UserPosition userPosition);

    List<StaffList> findByEmploymentBetween(float lower, float higher);
}