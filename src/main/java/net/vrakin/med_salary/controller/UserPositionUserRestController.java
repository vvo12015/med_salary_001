package net.vrakin.med_salary.controller;

import net.vrakin.med_salary.domain.mapping.users.User;
import net.vrakin.med_salary.dto.UserPositionUserDTO;
import net.vrakin.med_salary.dto.UserPositionUserSavedDTO;
import net.vrakin.med_salary.domain.*;
import net.vrakin.med_salary.exception.IdMismatchException;
import net.vrakin.med_salary.exception.ResourceExistException;
import net.vrakin.med_salary.exception.ResourceNotFoundException;
import net.vrakin.med_salary.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-position-user")
public class UserPositionUserRestController {

    private final UserService userService;
    private final UserPositionService userPositionService;
    private final UserPositionUserService userPositionUserService;
    private final UserPositionUserMapper userPositionUserMapper;

    @Autowired
    public UserPositionUserRestController(UserService userService, UserPositionService userPositionService,
                                          UserPositionUserService userPositionUserService,
                                          UserPositionUserMapper userPositionUserMapper) {
        this.userService = userService;
        this.userPositionService = userPositionService;
        this.userPositionUserService = userPositionUserService;
        this.userPositionUserMapper = userPositionUserMapper;
    }

    @GetMapping
    public ResponseEntity<List<UserPositionUserDTO>> getAll() {
        List<UserPositionUserDTO> users = userPositionUserMapper.toDtoList(userPositionUserService.findAll());
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserPositionUserDTO> getById(@PathVariable Long id) throws ResourceNotFoundException {
        StaffList staffList = userPositionUserService.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("UserPositionUser", "id", id.toString()));

        UserPositionUserDTO userPositionUserDTO = userPositionUserMapper.toDto(staffList);

        return new ResponseEntity<>(userPositionUserDTO, HttpStatus.OK);
    }

    @GetMapping("/user/{userRef}")
    public ResponseEntity<List<UserPositionUserDTO>> getByUser(@PathVariable Long userRef) throws ResourceNotFoundException {

        User user = userService.findById(userRef)
                .orElseThrow(()->new ResourceNotFoundException("User", "id", userRef.toString()));

        List<UserPositionUserDTO> userPositionUserDTOs = userPositionUserMapper
                .toDtoList(userPositionUserService.findByUser(user));

        return new ResponseEntity<>(userPositionUserDTOs, HttpStatus.OK);
    }

    @GetMapping("/userPosition/{userPositionRef}")
    public ResponseEntity<List<UserPositionUserDTO>> getByRole(@PathVariable Long userPositionRef) throws ResourceNotFoundException {

        UserPosition userPosition = userPositionService.findById(userPositionRef)
                .orElseThrow(()->new ResourceNotFoundException("UserPosition", "id", userPositionRef.toString()));

        List<UserPositionUserDTO> userPositionUserDTOs = userPositionUserMapper
                .toDtoList(userPositionUserService.findByUserPosition(userPosition));

        return new ResponseEntity<>(userPositionUserDTOs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserPositionUserDTO> add(@RequestBody UserPositionUserSavedDTO userPositionUserSavedDTO) {

        if (userPositionUserSavedDTO.getId() != null) {
            throw new ResourceExistException("UserPositionUserSavedDTO", userPositionUserSavedDTO.getId().toString());
        }

        StaffList staffList = userPositionUserMapper.toEntity(userPositionUserSavedDTO);

        UserPositionUserDTO savedUserPositionUser = userPositionUserMapper.toDto(userPositionUserService.save(staffList));

        return new ResponseEntity<>(savedUserPositionUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        try {
            userPositionUserService.deleteById(id);
        }catch (ResourceNotFoundException e){
            throw new ResourceNotFoundException("UserPositionUser", "id", id.toString());
        }
        return ResponseEntity.ok("UserPositionUser deleted successfully!.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserPositionUserDTO> updateUser(@PathVariable Long id,
                                                          @RequestBody UserPositionUserSavedDTO userPositionUserSavedDTO) {

        if (!userPositionUserSavedDTO.getId().equals(id)){
            throw new IdMismatchException("UserPositionUser", id.toString(), userPositionUserSavedDTO.getId().toString());
        }

        userPositionUserService.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("UserPositionUser", "id", id.toString()));


        StaffList staffList = userPositionUserMapper.toEntity(userPositionUserSavedDTO);


        UserPositionUserDTO savedUserPositionUserDTO = userPositionUserMapper
                .toDto(userPositionUserService.save(staffList));

        return new ResponseEntity<>(savedUserPositionUserDTO, HttpStatus.OK);
    }
}
