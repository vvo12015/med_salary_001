package net.vrakin.med_salary.service;

import lombok.extern.slf4j.Slf4j;
import net.vrakin.med_salary.domain.Role;
import net.vrakin.med_salary.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class RoleServiceImpl extends AbstractService<Role> implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository repository){
        super(repository);
        this.roleRepository = repository;
    }

    @Override
    public Optional<Role> findByName(String name) {
        return roleRepository.findByName(name);
    }
}
