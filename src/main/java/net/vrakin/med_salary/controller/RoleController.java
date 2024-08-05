package net.vrakin.med_salary.controller;

import lombok.extern.slf4j.Slf4j;
import net.vrakin.med_salary.dto.RoleDTO;
import net.vrakin.med_salary.dto.SavedRoleDTO;
import net.vrakin.med_salary.dto.UserDTO;
import net.vrakin.med_salary.entity.Role;
import net.vrakin.med_salary.entity.User;
import net.vrakin.med_salary.exception.IdMismatchException;
import net.vrakin.med_salary.exception.ResourceNotFoundException;
import net.vrakin.med_salary.mapper.RoleMapper;
import net.vrakin.med_salary.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@Slf4j
public class RoleController {

    private final RoleService roleService;
    private final RoleMapper roleMapper;

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
    public ResponseEntity<RoleDTO> add(@RequestBody SavedRoleDTO roleDTO) {

        log.info("RoleDTO from request {}", roleDTO.toString());

        Role role = roleService.save(roleMapper.toEntity(roleDTO));

        RoleDTO savedRole = roleMapper.toDto(role);

        return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteById(@PathVariable Long id) {
        roleService.deleteById(id);
        return HttpStatus.NO_CONTENT;
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDTO> updateRole(@PathVariable Long id, @RequestBody RoleDTO roleDTO) {
        if (!roleDTO.getId().equals(id)){
            throw new IdMismatchException("RoleDTO", id.toString(), roleDTO.getId().toString());
        }

        roleService.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Role", "id", id.toString()));


        Role role = roleMapper.toEntity(roleDTO);


        RoleDTO savedRoleDTO = roleMapper.toDto(roleService.save(role));

        return new ResponseEntity<>(savedRoleDTO, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<RoleDTO> getByName(@PathVariable String name) throws ResourceNotFoundException {
        Role role = roleService.findByName(name)
                .orElseThrow(()->new ResourceNotFoundException("Role", "name", name));

        RoleDTO roleDTO = roleMapper.toDto(role);

        return new ResponseEntity<>(roleDTO, HttpStatus.OK);
    }
}
