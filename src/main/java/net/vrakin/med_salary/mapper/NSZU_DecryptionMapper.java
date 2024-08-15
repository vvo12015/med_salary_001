package net.vrakin.med_salary.mapper;

import lombok.NoArgsConstructor;
import net.vrakin.med_salary.dto.NSZU_Decryption_DTO;
import net.vrakin.med_salary.entity.NSZU_Decryption;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
@NoArgsConstructor
public abstract class NSZU_DecryptionMapper extends AbstractMapper<NSZU_Decryption, NSZU_Decryption_DTO> {

    public abstract NSZU_Decryption_DTO toDto(NSZU_Decryption entity);

    public abstract NSZU_Decryption toEntity(NSZU_Decryption_DTO dto);
}