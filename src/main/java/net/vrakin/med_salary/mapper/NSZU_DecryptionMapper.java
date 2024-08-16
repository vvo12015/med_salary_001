package net.vrakin.med_salary.mapper;

import lombok.NoArgsConstructor;
import net.vrakin.med_salary.dto.NSZUDecryptionDTO;
import net.vrakin.med_salary.entity.NSZU_Decryption;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
@NoArgsConstructor
public abstract class NSZU_DecryptionMapper extends AbstractMapper<NSZU_Decryption, NSZUDecryptionDTO> {

    @Mapping(target = "EDRPOU", source = "EDRPOU")
    @Mapping(target = "ADSG", source = "ADSG")
    public abstract NSZUDecryptionDTO toDto(NSZU_Decryption entity);

    @Mapping(target = "EDRPOU", source = "EDRPOU")
    @Mapping(target = "ADSG", source = "ADSG")
    public abstract NSZU_Decryption toEntity(NSZUDecryptionDTO dto);
}