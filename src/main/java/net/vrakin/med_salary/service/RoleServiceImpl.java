package net.vrakin.med_salary.service;

import net.vrakin.med_salary.dto.RoleDTO;
import net.vrakin.med_salary.entity.Role;
import net.vrakin.med_salary.mapper.RoleMapper;
import net.vrakin.med_salary.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl extends AbstractService<Role, RoleDTO> implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository repository, RoleMapper mapper){
        super(repository, mapper);
        this.roleRepository = repository;
    }

    @Override
    public List<RoleDTO> findByName(String name) {
        return getDTOCollect(roleRepository.findByName(name));
    }
}
