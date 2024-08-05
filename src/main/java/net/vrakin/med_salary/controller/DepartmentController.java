package net.vrakin.med_salary.controller;

import lombok.AllArgsConstructor;
import net.vrakin.med_salary.dto.DepartmentDTO;
import net.vrakin.med_salary.dto.DepartmentDTO;
import net.vrakin.med_salary.dto.RoleDTO;
import net.vrakin.med_salary.dto.SavedDepartmentDTO;
import net.vrakin.med_salary.entity.Department;
import net.vrakin.med_salary.entity.Department;
import net.vrakin.med_salary.entity.Role;
import net.vrakin.med_salary.exception.IdMismatchException;
import net.vrakin.med_salary.exception.ResourceNotFoundException;
import net.vrakin.med_salary.mapper.DepartmentMapper;
import net.vrakin.med_salary.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;
    private final DepartmentMapper departmentMapper;

    @Autowired
    public DepartmentController(DepartmentService departmentService, DepartmentMapper departmentMapper) {
        this.departmentService = departmentService;
        this.departmentMapper = departmentMapper;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAll() {
        List<DepartmentDTO> departments = departmentMapper.toDtoList(departmentService.findAll());
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> getById(@PathVariable Long id) throws ResourceNotFoundException {
        DepartmentDTO department = departmentMapper.toDto(departmentService.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Department", "id", id.toString())));

        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> add(@RequestBody SavedDepartmentDTO departmentDTO) {

        Department department = departmentService.save(departmentMapper.toEntity(departmentDTO));

        DepartmentDTO savedDepartment = departmentMapper.toDto(department);

        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteById(@PathVariable Long id) {
        departmentService.deleteById(id);
        return HttpStatus.NO_CONTENT;
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDTO> updateDepartment(@PathVariable Long id, @RequestBody DepartmentDTO departmentDTO) {
        if (!departmentDTO.getId().equals(id)){
            throw new IdMismatchException("RoleDTO", id.toString(), departmentDTO.getId().toString());
        }

        departmentService.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Role", "id", id.toString()));


        Department department = departmentMapper.toEntity(departmentDTO);


        DepartmentDTO savedDepartmentDTO = departmentMapper.toDto(departmentService.save(department));

        return new ResponseEntity<>(savedDepartmentDTO, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<DepartmentDTO> getByName(@PathVariable String name) throws ResourceNotFoundException {
        Department department = departmentService.findByName(name)
                .orElseThrow(()->new ResourceNotFoundException("Department", "name", name));

        DepartmentDTO departmentDTO = departmentMapper.toDto(department);

        return new ResponseEntity<>(departmentDTO, HttpStatus.OK);
    }
}
