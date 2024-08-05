package net.vrakin.med_salary.service;

import net.vrakin.med_salary.dto.RoleDTO;
import net.vrakin.med_salary.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleService extends Service<Role>{
    Optional<Role> findByName(String name);
}
