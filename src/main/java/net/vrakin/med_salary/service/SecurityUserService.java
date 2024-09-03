package net.vrakin.med_salary.service;

import net.vrakin.med_salary.domain.SecurityRole;
import net.vrakin.med_salary.domain.SecurityUser;

import java.util.List;
import java.util.Optional;

public interface SecurityUserService extends Service<SecurityUser>{
    Optional<SecurityUser> findByLogin(String login);
    Optional<SecurityUser> findByEmail(String email);
    List<SecurityUser> findBySecurityRole(SecurityRole securityRole);
}
