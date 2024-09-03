package net.vrakin.med_salary.service;

import net.vrakin.med_salary.domain.Department;
import net.vrakin.med_salary.domain.mapping.users.User;
import net.vrakin.med_salary.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
    public Optional<Department> findByManager(User manager){
        return departmentRepository.findByManager(manager);
    }
}
