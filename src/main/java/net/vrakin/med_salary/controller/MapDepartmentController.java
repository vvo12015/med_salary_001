package net.vrakin.med_salary.controller;

import net.vrakin.med_salary.domain.mapping.department.MapDepartment;
import net.vrakin.med_salary.domain.mapping.department.MapDepartmentUser;
import net.vrakin.med_salary.dto.MapDepartmentDTO;
import net.vrakin.med_salary.exception.IdMismatchException;
import net.vrakin.med_salary.exception.ResourceExistException;
import net.vrakin.med_salary.exception.ResourceNotFoundException;
import net.vrakin.med_salary.mapper.MapDepartmentMapper;
import net.vrakin.med_salary.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/map-department")
public class MapDepartmentController {

    private MapDepartmentMapper mapDepartmentMapper;

    private MapDepartmentService mapDepartmentService;

    @GetMapping
    public ResponseEntity<List<MapDepartmentDTO>> getAll() {
        List<MapDepartmentDTO> mapDepartmentDTOs = mapDepartmentMapper.toDtoList(mapDepartmentService.findAll());
        return new ResponseEntity<>(mapDepartmentDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MapDepartmentDTO> getById(@PathVariable Long id) throws ResourceNotFoundException {
        MapDepartment mapDepartment = mapDepartmentService.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("NSZU_Decryption", "id", id.toString()));

        MapDepartmentDTO mapDepartmentDTO = mapDepartmentMapper.toDto(mapDepartment);

        return new ResponseEntity<>(mapDepartmentDTO, HttpStatus.OK);
    }

    @GetMapping("/position-department")
    public ResponseEntity<MapDepartmentUser> getByUserPositionDepartment(@RequestParam String departmentID,
                                                                         @RequestParam String userPositionId){
        String paramsString = String.format("departmentID: %s, userPositionId: %s", departmentID, userPositionId);
        MapDepartmentUser mapDepartmentUser = mapDepartmentService.findByDepartmentIsProIdAndUserId(departmentID, userPositionId)
                .orElseThrow(()->new ResourceNotFoundException("MapDepartmentUser", paramsString, null));
        return new ResponseEntity<>(mapDepartmentUser, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MapDepartmentDTO> add(@RequestBody MapDepartmentDTO mapDepartmentDTO) {

        if (mapDepartmentDTO.getId() != null) {
            throw new ResourceExistException("MapDepartmentDTO", mapDepartmentDTO.getId().toString());
        }

        MapDepartment mapDepartment = mapDepartmentMapper.toEntity(mapDepartmentDTO);

        MapDepartmentDTO savedMapDepartment = mapDepartmentMapper.toDto(mapDepartmentService.save(mapDepartment));

        return new ResponseEntity<>(savedMapDepartment, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        try {
            mapDepartmentService.deleteById(id);
        }catch (ResourceNotFoundException e){
            throw new ResourceNotFoundException("MapDepartment", "id", id.toString());
        }
        return ResponseEntity.ok("MapDepartment deleted successfully!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<MapDepartmentDTO> updateUser(@PathVariable Long id, @RequestBody MapDepartmentDTO mapDepartmentDTO) {

        if (!mapDepartmentDTO.getId().equals(id)){
            throw new IdMismatchException("MapDepartment", id.toString(), mapDepartmentDTO.getId().toString());
        }

        mapDepartmentService.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("MapDepartment", "id", id.toString()));


        MapDepartment mapDepartment = mapDepartmentMapper.toEntity(mapDepartmentDTO);


        MapDepartmentDTO savedMapDepartmentDTO = mapDepartmentMapper.toDto(mapDepartmentService.save(mapDepartment));

        return new ResponseEntity<>(savedMapDepartmentDTO, HttpStatus.OK);
    }
}
