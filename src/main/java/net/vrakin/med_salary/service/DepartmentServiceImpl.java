package net.vrakin.med_salary.service;

import net.vrakin.med_salary.dto.DepartmentDTO;
import net.vrakin.med_salary.dto.RoleDTO;
import net.vrakin.med_salary.entity.Department;
import net.vrakin.med_salary.entity.Role;
import net.vrakin.med_salary.mapper.DepartmentMapper;
import net.vrakin.med_salary.mapper.RoleMapper;
import net.vrakin.med_salary.repository.DepartmentRepository;
import net.vrakin.med_salary.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl extends AbstractService<Department, DepartmentDTO> implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository repository, DepartmentMapper mapper){
        super(repository, mapper);
        this.departmentRepository = repository;
    }

    @Override
    public List<DepartmentDTO> findByName(String name) {
        return getDTOCollect(departmentRepository.findByName(name));
    }
}
