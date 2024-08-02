package net.vrakin.med_salary.controller;

import net.vrakin.med_salary.entity.User;
import net.vrakin.med_salary.exception.ResourceNotFoundException;
import net.vrakin.med_salary.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(@Autowired UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.findById(id).orElseThrow(()->new ResourceNotFoundException("User", "id", id));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        userService.save(user);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteById(@PathVariable Long id) {
        User existingUser = userService.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );
        return new ResponseEntity<>(existingUser, HttpStatus.OK);
    }
}
