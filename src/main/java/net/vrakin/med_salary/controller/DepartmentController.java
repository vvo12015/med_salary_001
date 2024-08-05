package net.vrakin.med_salary.controller;

import lombok.AllArgsConstructor;
import net.vrakin.med_salary.dto.DepartmentDTO;
import net.vrakin.med_salary.entity.Department;
import net.vrakin.med_salary.exception.ResourceNotFoundException;
import net.vrakin.med_salary.mapper.DepartmentMapper;
import net.vrakin.med_salary.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;
    private DepartmentMapper departmentMapper;

    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
        List<DepartmentDTO> departments = departmentMapper.toDtoList(departmentService.findAll());
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Long id) throws RuntimeException {
        DepartmentDTO department = departmentMapper.toDto(departmentService.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Department", "id", id.toString())));
        
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DepartmentDTO> addDepartment(@RequestBody DepartmentDTO departmentDTO) {
        Department department = departmentService.save(departmentMapper.toEntity(departmentDTO));

        DepartmentDTO savedDepartmentDTO = departmentMapper.toDto(department);

        return new ResponseEntity<>(savedDepartmentDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteById(@PathVariable Long id) {
        departmentService.deleteById(id);
        return HttpStatus.OK;
    }
}
