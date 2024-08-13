package net.vrakin.med_salary.service;

import net.vrakin.med_salary.entity.*;

import java.util.List;
import java.util.Optional;

public interface UserPositionUserService extends Service<UserPositionUser> {

    List<UserPositionUser> findByUser(User user);

    List<UserPositionUser> findByUserPosition(UserPosition userPosition);

    List<UserPositionUser> findByEmploymentBetween(float lower, float higher);
}