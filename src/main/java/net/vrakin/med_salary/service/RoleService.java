package net.vrakin.med_salary.service;

import net.vrakin.med_salary.dto.RoleDTO;

import java.util.List;

public interface RoleService extends Service<RoleDTO>{
    List<RoleDTO> findByName(String name);
}
