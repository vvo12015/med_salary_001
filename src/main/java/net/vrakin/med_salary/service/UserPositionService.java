package net.vrakin.med_salary.service;

import net.vrakin.med_salary.entity.Role;
import net.vrakin.med_salary.entity.UserPosition;

import java.util.Optional;

public interface UserPositionService extends Service<UserPosition>{
    Optional<UserPosition> findByName(String name);
}
