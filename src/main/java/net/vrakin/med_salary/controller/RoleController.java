package net.vrakin.med_salary.controller;

import lombok.AllArgsConstructor;
import net.vrakin.med_salary.dto.RoleDTO;
import net.vrakin.med_salary.exception.ResourceNotFoundException;
import net.vrakin.med_salary.service.RoleService;
import net.vrakin.med_salary.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
@AllArgsConstructor
public class RoleController {

    private RoleService roleService;

    @GetMapping
    public ResponseEntity<List<RoleDTO>> getAllRoles() {
        List<RoleDTO> roles = roleService.findAll();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> getRoleById(@PathVariable Long id) throws RuntimeException {
        RoleDTO role = roleService.findById(id).orElseThrow(()->new ResourceNotFoundException("Role", "id", id.toString()));
        
        return new ResponseEntity<>(role, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RoleDTO> addRole(@RequestBody RoleDTO role) {
        roleService.save(role);

        return new ResponseEntity<>(role, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteById(@PathVariable Long id) {
        roleService.deleteById(id);
        return HttpStatus.OK;
    }
}
