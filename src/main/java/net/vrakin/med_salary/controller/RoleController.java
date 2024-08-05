package net.vrakin.med_salary.controller;

import lombok.AllArgsConstructor;
import net.vrakin.med_salary.dto.DepartmentDTO;
import net.vrakin.med_salary.dto.RoleDTO;
import net.vrakin.med_salary.dto.RoleDTO;
import net.vrakin.med_salary.entity.Role;
import net.vrakin.med_salary.exception.ResourceNotFoundException;
import net.vrakin.med_salary.mapper.RoleMapper;
import net.vrakin.med_salary.mapper.UserMapper;
import net.vrakin.med_salary.service.DepartmentService;
import net.vrakin.med_salary.service.RoleService;
import net.vrakin.med_salary.service.RoleService;
import net.vrakin.med_salary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private RoleService roleService;
    private RoleMapper roleMapper;

    @Autowired
    public RoleController(RoleMapper roleMapper,
                          RoleService roleService) {
        this.roleMapper = roleMapper;
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<RoleDTO>> getAll() {
        List<RoleDTO> roles = roleMapper.toDtoList(roleService.findAll());
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> getById(@PathVariable Long id) throws ResourceNotFoundException {
        RoleDTO role = roleMapper.toDto(roleService.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Role", "id", id.toString())));

        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RoleDTO> add(@RequestBody RoleDTO roleDTO) {
        Role role = roleService.save(roleMapper.toEntity(roleDTO));

        RoleDTO savedRole = roleMapper.toDto(role);

        return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteById(@PathVariable Long id) {
        roleService.deleteById(id);
        return HttpStatus.OK;
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDTO> updateRole(@PathVariable Long id, @RequestBody RoleDTO role) {
        roleService.save(roleMapper.toEntity(role));

        return new ResponseEntity<>(role, HttpStatus.OK);
    }
}
