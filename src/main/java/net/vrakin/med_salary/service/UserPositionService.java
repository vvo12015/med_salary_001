package net.vrakin.med_salary.service;

import net.vrakin.med_salary.domain.UserPosition;

import java.util.Optional;

public interface UserPositionService extends Service<UserPosition>{
    Optional<UserPosition> findByName(String name);
}
