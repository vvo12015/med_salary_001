package net.vrakin.med_salary.controller;

import net.vrakin.med_salary.domain.NszuDecryption;
import net.vrakin.med_salary.domain.UserPosition;
import net.vrakin.med_salary.domain.mapping.department.MapDepartment;
import net.vrakin.med_salary.domain.mapping.users.StaffList;
import net.vrakin.med_salary.dto.NszuDecryptionDTO;
import net.vrakin.med_salary.dto.StaffListDTO;
import net.vrakin.med_salary.exception.IdMismatchException;
import net.vrakin.med_salary.exception.ResourceExistException;
import net.vrakin.med_salary.exception.ResourceNotFoundException;
import net.vrakin.med_salary.mapper.StaffListMapper;
import net.vrakin.med_salary.service.StaffListService;
import net.vrakin.med_salary.service.UserPositionService;
import net.vrakin.med_salary.service.mapper.MapDepartmentService;
import net.vrakin.med_salary.service.mapper.MapperService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nzsu_decryption")
public class StaffListController {

    private StaffListMapper staffListMapper;

    private StaffListService staffListService;
    private MapperService staffListMapperService;
    private UserPositionService userPositionService;
    private MapDepartmentService mapDepartmentService;

    public StaffListController(StaffListMapper staffListMapper, StaffListService staffListService, MapperService staffListMapperService) {
        this.staffListMapper = staffListMapper;
        this.staffListService = staffListService;
        this.staffListMapperService = staffListMapperService;
    }

    @GetMapping
    public ResponseEntity<List<StaffListDTO>> getAll() {
        List<StaffListDTO> staffListDTOs = staffListMapper.toDtoList(staffListService.findAll());
        return new ResponseEntity<>(staffListDTOs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StaffListDTO> getById(@PathVariable Long id) throws ResourceNotFoundException {
        StaffList staffList = staffListService.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("NSZU_Decryption", "id", id.toString()));

        StaffListDTO staffListDTO = staffListMapper.toDto(staffList);

        return new ResponseEntity<>(staffListDTO, HttpStatus.OK);
    }

    @GetMapping("/position-department")
    public ResponseEntity<List<NszuDecryptionDTO>> getByUserPositionDepartment(@RequestParam Long userPositionId,
                                                                     @RequestParam Long departmentID){
        UserPosition userPosition = userPositionService.findById(userPositionId)
                .orElseThrow(()->new ResourceNotFoundException("StaffList", "userPositionId", userPositionId.toString()));
        MapDepartment mapDepartment = mapDepartmentService.findById(departmentID)
                .orElseThrow(()->new ResourceNotFoundException("StaffList", "mapDepartment", departmentID.toString()));
        List<NszuDecryptionDTO> nszuDecryptionDtoList = staffListMapper.toDtoList(
                staffListService.findByUserPositionDepartment(userPosition, mapDepartment));

        return new ResponseEntity<>(nszuDecryptionDtoList, HttpStatus.OK);
    }

    @GetMapping("/recordKind/{recordKind}")
    public ResponseEntity<List<NszuDecryptionDTO>> getByRecordKind(@PathVariable String recordKind,
                                                                   @RequestParam int year, @RequestParam int month) {

        List<NszuDecryptionDTO> nszuDecryptionDtoList = nszuDecryptionMapper
                .toDtoList(nszuDecryptionService.findByRecordKind(recordKind).stream().filter(nszu_decryption -> {
                    return ((nszu_decryption.getYear()==year)
                            && (nszu_decryption.getYear()==month));
                })
                .toList());

        return new ResponseEntity<>(nszuDecryptionDtoList, HttpStatus.OK);
    }

    @GetMapping("/providerPlace/{providerPlace}")
    public ResponseEntity<List<NszuDecryptionDTO>> getByProviderPlace(@PathVariable String providerPlace,
                                                                      @RequestParam int year, @RequestParam int month){

        List<NszuDecryptionDTO> nszuDecryptionDtoList = nszuDecryptionMapper
                .toDtoList(nszuDecryptionService.findByProviderPlace(providerPlace).stream().filter(nszu_decryption -> {
                            return ((nszu_decryption.getYear()==year)
                                    && (nszu_decryption.getYear()==month));
                        })
                        .toList());

        return new ResponseEntity<>(nszuDecryptionDtoList, HttpStatus.OK);
    }

    @GetMapping("/servicePackage/{servicePackage}")
    public ResponseEntity<List<NszuDecryptionDTO>> getByServicePackage(@PathVariable String servicePackage,
                                                                       @RequestParam int year, @RequestParam int month){

        List<NszuDecryptionDTO> nszuDecryptionDtoList = nszuDecryptionMapper
                .toDtoList(nszuDecryptionService.findByServicePackage(servicePackage).stream().filter(nszu_decryption -> {
                            return ((nszu_decryption.getYear()==year)
                                    && (nszu_decryption.getMonth()==month));
                        })
                        .toList());

        return new ResponseEntity<>(nszuDecryptionDtoList, HttpStatus.OK);
    }

    @GetMapping("/executorName/{executorName}")
    public ResponseEntity<List<NszuDecryptionDTO>> getByExecutorName(@PathVariable String executorName,
                                                                     @RequestParam int year, @RequestParam int month){

        List<NszuDecryptionDTO> nszuDecryptionDtoList = nszuDecryptionMapper
                .toDtoList(nszuDecryptionService.findByExecutorName(executorName));

        if ((year != 0) && (month != 0)){
            nszuDecryptionDtoList = nszuDecryptionDtoList.stream().filter(nszu_decryption -> {
                        return ((nszu_decryption.getYear()==year)
                                && (nszu_decryption.getMonth()==month));
                    })
                    .toList();
        }

        return new ResponseEntity<>(nszuDecryptionDtoList, HttpStatus.OK);
    }

    @GetMapping("/executorName-userPosition/{executorName}/{userPosition}")
    public ResponseEntity<List<NszuDecryptionDTO>> getByExecutorNameAndUserPosition(
            @PathVariable String executorName, @PathVariable String userPosition,
                                                                     @RequestParam int year, @RequestParam int month){

        List<NszuDecryptionDTO> nszuDecryptionDtoList = nszuDecryptionMapper
                .toDtoList(nszuDecryptionService.findByExecutorNameAndExecutorUserPosition(executorName, userPosition));

        if ((year != 0) && (month != 0)){
            nszuDecryptionDtoList = nszuDecryptionDtoList.stream().filter(nszu_decryption -> {
                        return ((nszu_decryption.getYear()==year)
                                && (nszu_decryption.getMonth()==month));
                    })
                    .toList();
        }

        return new ResponseEntity<>(nszuDecryptionDtoList, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<NszuDecryptionDTO> add(@RequestBody NszuDecryptionDTO nszuDecryptionDTO) {

        if (nszuDecryptionDTO.getId() != null) {
            throw new ResourceExistException("NSZU_DecryptionDTO", nszuDecryptionDTO.getId().toString());
        }

        NszuDecryption nszuDecryption = nszuDecryptionMapper.toEntity(nszuDecryptionDTO);

        NszuDecryptionDTO savedNSZUDecryption = nszuDecryptionMapper.toDto(nszuDecryptionService.save(nszuDecryption));

        return new ResponseEntity<>(savedNSZUDecryption, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        try {
            nszuDecryptionService.deleteById(id);
        }catch (ResourceNotFoundException e){
            throw new ResourceNotFoundException("NSZU_Decryption", "id", id.toString());
        }
        return ResponseEntity.ok("NSZU_Decryption deleted successfully!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<NszuDecryptionDTO> updateUser(@PathVariable Long id, @RequestBody NszuDecryptionDTO nszuDecryptionDTO) {

        if (!nszuDecryptionDTO.getId().equals(id)){
            throw new IdMismatchException("NSZUDecryptionDTO", id.toString(), nszuDecryptionDTO.getId().toString());
        }

        nszuDecryptionService.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("NSZUDecryption", "id", id.toString()));


        NszuDecryption nszuDecryption = nszuDecryptionMapper.toEntity(nszuDecryptionDTO);


        NszuDecryptionDTO savedNSZU_DecryptionDTO = nszuDecryptionMapper.toDto(nszuDecryptionService.save(nszuDecryption));

        return new ResponseEntity<>(savedNSZU_DecryptionDTO, HttpStatus.OK);
    }
}
