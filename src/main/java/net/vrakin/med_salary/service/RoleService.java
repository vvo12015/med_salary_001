package net.vrakin.med_salary.service;

import net.vrakin.med_salary.dto.RoleDTO;
import net.vrakin.med_salary.entity.Role;

import java.util.List;

public interface RoleService extends Service<Role>{
    List<Role> findByName(String name);
}
