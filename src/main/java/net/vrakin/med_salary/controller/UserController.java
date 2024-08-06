package net.vrakin.med_salary.controller;

import net.vrakin.med_salary.dto.UserSavedDTO;
import net.vrakin.med_salary.dto.UserDTO;
import net.vrakin.med_salary.entity.Department;
import net.vrakin.med_salary.entity.Role;
import net.vrakin.med_salary.entity.User;
import net.vrakin.med_salary.exception.IdMismatchException;
import net.vrakin.med_salary.exception.ResourceExistException;
import net.vrakin.med_salary.exception.ResourceNotFoundException;
import net.vrakin.med_salary.mapper.UserMapper;
import net.vrakin.med_salary.service.DepartmentService;
import net.vrakin.med_salary.service.RoleService;
import net.vrakin.med_salary.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    private final DepartmentService departmentService;

    private final RoleService roleService;

    @Autowired
    public UserController(UserService userService,
                          UserMapper userMapper,
                          DepartmentService departmentService,
                          RoleService roleService) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.departmentService = departmentService;
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll() {
        List<UserDTO> users = userMapper.toDtoList(userService.findAll());
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long id) throws ResourceNotFoundException {
        User user = userService.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User", "id", id.toString()));

        UserDTO userDTO = userMapper.toDto(user);

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping("/login/{login}")
    public ResponseEntity<UserDTO> getByLogin(@PathVariable String login) throws ResourceNotFoundException {
        User user = userService.findByLogin(login)
                .orElseThrow(()->new ResourceNotFoundException("User", "login", login));

        UserDTO userDTO = userMapper.toDto(user);

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping("/name/{namePattern}")
    public ResponseEntity<List<UserDTO>> getByLikeName(@PathVariable String namePattern) throws ResourceNotFoundException {
        List<UserDTO> users = userMapper.toDtoList(userService.findByNameLike(namePattern));

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/department/{departmentRef}")
    public ResponseEntity<List<UserDTO>> getByDepartment(@PathVariable Long departmentRef) throws ResourceNotFoundException {

        Department department = departmentService.findById(departmentRef)
                .orElseThrow(()->new ResourceNotFoundException("Department", "id", departmentRef.toString()));

        List<UserDTO> users = userMapper.toDtoList(userService.findByDepartment(department));

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/speciality/{name}")
    public ResponseEntity<List<UserDTO>> getBySpecialityName(@PathVariable String name) throws ResourceNotFoundException {
        List<UserDTO> users = userMapper.toDtoList(userService.findBySpecialty(name));

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/role/{roleRef}")
    public ResponseEntity<List<UserDTO>> getByRole(@PathVariable Long roleRef) throws ResourceNotFoundException {

        Role role = roleService.findById(roleRef)
                .orElseThrow(()->new ResourceNotFoundException("Role", "id", roleRef.toString()));

        List<UserDTO> users = userMapper.toDtoList(userService.findByRole(role));

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDTO> add(@RequestBody UserSavedDTO userDto) {

        if (userDto.getId() != null) {
            throw new ResourceExistException("UserId", userDto.getId().toString());
        }

        User user = userMapper.toEntity(userDto);

        UserDTO savedUser = userMapper.toDto(userService.save(user));

        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        try {
            userService.deleteById(id);
        }catch (ResourceNotFoundException e){
            throw new ResourceNotFoundException("User", "id", id.toString());
        }
        return ResponseEntity.ok("User deleted successfully!.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserSavedDTO userDTO) {

        if (!userDTO.getId().equals(id)){
            throw new IdMismatchException("User", id.toString(), userDTO.getId().toString());
        }

        userService.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("User", "id", id.toString()));


        User user = userMapper.toEntity(userDTO);


        UserDTO savedUser = userMapper.toDto(userService.save(user));

        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }
}
