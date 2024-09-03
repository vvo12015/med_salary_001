package net.vrakin.med_salary.service;

import net.vrakin.med_salary.domain.Role;

import java.util.Optional;

public interface RoleService extends Service<Role>{
    Optional<Role> findByName(String name);
}
