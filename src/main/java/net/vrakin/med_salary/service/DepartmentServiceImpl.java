package net.vrakin.med_salary.service;

import net.vrakin.med_salary.dto.DepartmentDTO;
import net.vrakin.med_salary.dto.RoleDTO;
import net.vrakin.med_salary.entity.Department;
import net.vrakin.med_salary.entity.Role;
import net.vrakin.med_salary.entity.User;
import net.vrakin.med_salary.exception.ResourceNotFoundException;
import net.vrakin.med_salary.mapper.DepartmentMapper;
import net.vrakin.med_salary.mapper.RoleMapper;
import net.vrakin.med_salary.repository.DepartmentRepository;
import net.vrakin.med_salary.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl extends AbstractService<Department> implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository repository){
        super(repository);
        this.departmentRepository = repository;
    }

    @Override
    public Optional<Department> findByName(String name) {
        return departmentRepository.findByName(name);
    }

    @Override
    public List<Department> findByManager(User manager){
        return departmentRepository.findByManager(manager);
    }
}
