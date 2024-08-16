package net.vrakin.med_salary.controller;

import net.vrakin.med_salary.dto.NSZUDecryptionDTO;
import net.vrakin.med_salary.entity.NSZU_Decryption;
import net.vrakin.med_salary.exception.IdMismatchException;
import net.vrakin.med_salary.exception.ResourceExistException;
import net.vrakin.med_salary.exception.ResourceNotFoundException;
import net.vrakin.med_salary.mapper.NSZU_DecryptionMapper;
import net.vrakin.med_salary.service.NSZU_DecryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nzsu_decryption")
public class NSZU_DecryptionController {

    private NSZU_DecryptionService nszuDecryptionService;
    private NSZU_DecryptionMapper nszuDecryptionMapper;

    @Autowired
    public NSZU_DecryptionController(NSZU_DecryptionService nszuDecryptionService,
                                     NSZU_DecryptionMapper nszuDecryptionMapper) {
        this.nszuDecryptionMapper = nszuDecryptionMapper;
        this.nszuDecryptionService = nszuDecryptionService;
    }

    @GetMapping
    public ResponseEntity<List<NSZUDecryptionDTO>> getAll() {
        List<NSZUDecryptionDTO> nszuDecryptionDtoList = nszuDecryptionMapper.toDtoList(nszuDecryptionService.findAll());
        return new ResponseEntity<>(nszuDecryptionDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NSZUDecryptionDTO> getById(@PathVariable Long id) throws ResourceNotFoundException {
        NSZU_Decryption nszuDecryption = nszuDecryptionService.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("NSZU_Decryption", "id", id.toString()));

        NSZUDecryptionDTO nszuDecryptionDto = nszuDecryptionMapper.toDto(nszuDecryption);

        return new ResponseEntity<>(nszuDecryptionDto, HttpStatus.OK);
    }

    @GetMapping("/date")
    public ResponseEntity<List<NSZUDecryptionDTO>> getByYearAndMonth(@RequestParam int year,
                                                                      @RequestParam int month){
        List<NSZUDecryptionDTO> nszuDecryptionDtoList = nszuDecryptionMapper.toDtoList(
                nszuDecryptionService.findByYearAndMonth(year, month));

        return new ResponseEntity<>(nszuDecryptionDtoList, HttpStatus.OK);
    }

    @GetMapping("/recordKind/{recordKind}")
    public ResponseEntity<List<NSZUDecryptionDTO>> getByRecordKind(@PathVariable String recordKind,
                                                          @RequestParam int year, @RequestParam int month) {

        List<NSZUDecryptionDTO> nszuDecryptionDtoList = nszuDecryptionMapper
                .toDtoList(nszuDecryptionService.findByRecordKind(recordKind).stream().filter(nszu_decryption -> {
                    return ((nszu_decryption.getYear()==year)
                            && (nszu_decryption.getYear()==month));
                })
                .toList());

        return new ResponseEntity<>(nszuDecryptionDtoList, HttpStatus.OK);
    }

    @GetMapping("/providerPlace/{providerPlace}")
    public ResponseEntity<List<NSZUDecryptionDTO>> getByProviderPlace(@PathVariable String providerPlace,
                                                                      @RequestParam int year, @RequestParam int month){

        List<NSZUDecryptionDTO> nszuDecryptionDtoList = nszuDecryptionMapper
                .toDtoList(nszuDecryptionService.findByProviderPlace(providerPlace).stream().filter(nszu_decryption -> {
                            return ((nszu_decryption.getYear()==year)
                                    && (nszu_decryption.getYear()==month));
                        })
                        .toList());

        return new ResponseEntity<>(nszuDecryptionDtoList, HttpStatus.OK);
    }

    @GetMapping("/servicePackage/{servicePackage}")
    public ResponseEntity<List<NSZUDecryptionDTO>> getByServicePackage(@PathVariable String servicePackage,
                                                                      @RequestParam int year, @RequestParam int month){

        List<NSZUDecryptionDTO> nszuDecryptionDtoList = nszuDecryptionMapper
                .toDtoList(nszuDecryptionService.findByServicePackage(servicePackage).stream().filter(nszu_decryption -> {
                            return ((nszu_decryption.getYear()==year)
                                    && (nszu_decryption.getMonth()==month));
                        })
                        .toList());

        return new ResponseEntity<>(nszuDecryptionDtoList, HttpStatus.OK);
    }

    @GetMapping("/executorName/{executorName}")
    public ResponseEntity<List<NSZUDecryptionDTO>> getByExecutorName(@PathVariable String executorName,
                                                                       @RequestParam int year, @RequestParam int month){

        List<NSZUDecryptionDTO> nszuDecryptionDtoList = nszuDecryptionMapper
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
    public ResponseEntity<List<NSZUDecryptionDTO>> getByExecutorNameAndUserPosition(
            @PathVariable String executorName, @PathVariable String userPosition,
                                                                     @RequestParam int year, @RequestParam int month){

        List<NSZUDecryptionDTO> nszuDecryptionDtoList = nszuDecryptionMapper
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
    public ResponseEntity<NSZUDecryptionDTO> add(@RequestBody NSZUDecryptionDTO nszuDecryptionDTO) {

        if (nszuDecryptionDTO.getId() != null) {
            throw new ResourceExistException("NSZU_DecryptionDTO", nszuDecryptionDTO.getId().toString());
        }

        NSZU_Decryption nszuDecryption = nszuDecryptionMapper.toEntity(nszuDecryptionDTO);

        NSZUDecryptionDTO savedNSZUDecryption = nszuDecryptionMapper.toDto(nszuDecryptionService.save(nszuDecryption));

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
    public ResponseEntity<NSZUDecryptionDTO> updateUser(@PathVariable Long id, @RequestBody NSZUDecryptionDTO nszuDecryptionDTO) {

        if (!nszuDecryptionDTO.getId().equals(id)){
            throw new IdMismatchException("NSZUDecryptionDTO", id.toString(), nszuDecryptionDTO.getId().toString());
        }

        nszuDecryptionService.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("NSZUDecryption", "id", id.toString()));


        NSZU_Decryption nszuDecryption = nszuDecryptionMapper.toEntity(nszuDecryptionDTO);


        NSZUDecryptionDTO savedNSZU_DecryptionDTO = nszuDecryptionMapper.toDto(nszuDecryptionService.save(nszuDecryption));

        return new ResponseEntity<>(savedNSZU_DecryptionDTO, HttpStatus.OK);
    }
}
