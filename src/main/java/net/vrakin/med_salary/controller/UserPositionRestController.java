package net.vrakin.med_salary.controller;

import lombok.extern.slf4j.Slf4j;
import net.vrakin.med_salary.dto.UserPositionDTO;
import net.vrakin.med_salary.entity.UserPosition;
import net.vrakin.med_salary.exception.IdMismatchException;
import net.vrakin.med_salary.exception.ResourceExistException;
import net.vrakin.med_salary.exception.ResourceNotFoundException;
import net.vrakin.med_salary.mapper.UserPositionMapper;
import net.vrakin.med_salary.service.UserPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-positions")
@Slf4j
public class UserPositionRestController {

    private final UserPositionService userPositionService;
    private final UserPositionMapper userPositionMapper;

    @Autowired
    public UserPositionRestController(UserPositionMapper userPositionMapper,
                                      UserPositionService userPositionService) {
        this.userPositionMapper = userPositionMapper;
        this.userPositionService = userPositionService;
    }

    @GetMapping
    public ResponseEntity<List<UserPositionDTO>> getAll() {
        List<UserPositionDTO> userPositions = userPositionMapper.toDtoList(userPositionService.findAll());
        return new ResponseEntity<>(userPositions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserPositionDTO> getById(@PathVariable Long id) throws ResourceNotFoundException {
        UserPositionDTO userPosition = userPositionMapper.toDto(userPositionService.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("UserPosition", "id", id.toString())));

        return new ResponseEntity<>(userPosition, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserPositionDTO> add(@RequestBody UserPositionDTO userPositionDTO) {

        if (userPositionDTO.getId() != null) {
            throw new ResourceExistException("UserPositionId", userPositionDTO.getId().toString());
        }

        UserPosition userPosition = userPositionService.save(userPositionMapper.toEntity(userPositionDTO));

        UserPositionDTO savedUserPosition = userPositionMapper.toDto(userPosition);

        return new ResponseEntity<>(savedUserPosition, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        try {
            userPositionService.deleteById(id);
        }catch (ResourceNotFoundException e){
            throw new ResourceNotFoundException("UserPosition", "id", id.toString());
        }
        return ResponseEntity.ok("UserPosition deleted successfully!.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserPositionDTO> updateUserPosition(@PathVariable Long id, @RequestBody UserPositionDTO userPositionDTO) {
        if (!userPositionDTO.getId().equals(id)){
            throw new IdMismatchException("UserPositionDTO", id.toString(), userPositionDTO.getId().toString());
        }

        userPositionService.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("UserPosition", "id", id.toString()));


        UserPosition userPosition = userPositionMapper.toEntity(userPositionDTO);


        UserPositionDTO savedUserPositionDTO = userPositionMapper.toDto(userPositionService.save(userPosition));

        return new ResponseEntity<>(savedUserPositionDTO, HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<UserPositionDTO> getByName(@PathVariable String name) throws ResourceNotFoundException {
        UserPosition userPosition = userPositionService.findByName(name)
                .orElseThrow(()->new ResourceNotFoundException("UserPosition", "name", name));

        UserPositionDTO userPositionDTO = userPositionMapper.toDto(userPosition);

        return new ResponseEntity<>(userPositionDTO, HttpStatus.OK);
    }
}
