package net.vrakin.med_salary.service;

import lombok.extern.slf4j.Slf4j;
import net.vrakin.med_salary.entity.Role;
import net.vrakin.med_salary.entity.User;
import net.vrakin.med_salary.exception.ResourceNotFoundException;
import net.vrakin.med_salary.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
