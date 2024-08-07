package net.vrakin.med_salary.service;

import net.vrakin.med_salary.entity.SecurityRole;
import net.vrakin.med_salary.entity.SecurityUser;

import java.util.List;
import java.util.Optional;

public interface SecurityUserService extends Service<SecurityUser>{
    Optional<SecurityUser> findByLogin(String login);
    Optional<SecurityUser> findByEmail(String email);
    List<SecurityUser> findBySecurityRole(SecurityRole securityRole);
}
