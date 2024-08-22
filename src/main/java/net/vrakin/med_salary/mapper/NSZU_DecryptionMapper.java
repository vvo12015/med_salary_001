package net.vrakin.med_salary.mapper;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.vrakin.med_salary.dto.NszuDecryptionDTO;
import net.vrakin.med_salary.entity.NszuDecryption;
import net.vrakin.med_salary.excel.ExcelHelper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
@Slf4j
@NoArgsConstructor
public abstract class NSZU_DecryptionMapper implements BaseMapper<NszuDecryption, NszuDecryptionDTO> {

    private ExcelHelper excelHelper;

    @Autowired
    public void setExcelHelper(ExcelHelper excelHelper) {
        this.excelHelper = excelHelper;
    }

    @Mapping(target = "EDRPOU", source = "EDRPOU")
    @Mapping(target = "ADSG", source = "ADSG")
    public abstract NszuDecryptionDTO toDto(NszuDecryption entity);

    @Mapping(target = "EDRPOU", source = "EDRPOU")
    @Mapping(target = "ADSG", source = "ADSG")
    public abstract NszuDecryption toEntity(NszuDecryptionDTO dto);

    public NszuDecryptionDTO toDto(String stringDTO) {

        List<String> stringList = Arrays.stream(stringDTO.split("&&"))
                .collect(Collectors.toList());

        stringList = stringList.stream().map(s->{
            if (s.equals(ExcelHelper.EMPTY_SING_EXCEL)) {
                return ExcelHelper.EMPTY_SING;
            }
            return s;
        }).toList();

        NszuDecryptionDTO dto = new NszuDecryptionDTO();
        int index = 0;
        dto.setYear(Integer.parseInt(stringList.get(index++)));
        dto.setMonth(Integer.parseInt(stringList.get(index++)));
        dto.setRecordKind(stringList.get(index++));
        dto.setRecordID(stringList.get(index++));
        dto.setCreationDate(excelHelper.mapToDate(stringList.get(index++)));
        dto.setExecutorUserPosition(stringList.get(index++));
        dto.setExecutorName(stringList.get(index++));
        dto.setProviderPlace(stringList.get(index++));
        dto.setReferralKind(stringList.get(index++));
        dto.setEDRPOU(stringList.get(index++));
        dto.setReferringUserPosition(stringList.get(index++));
        dto.setEpisodeId(stringList.get(index++));
        dto.setEpisodeKind(stringList.get(index++));
        dto.setEpisodeStartDate(excelHelper.mapToDate(stringList.get(index++)));
        dto.setPeriodStartDate(excelHelper.mapToDate(stringList.get(index++)));
        dto.setPeriodEndDate(excelHelper.mapToDate(stringList.get(index++)));
        dto.setPeriodLength(Integer.parseInt(stringList.get(index++)));
        dto.setMainDiagnosis(stringList.get(index++));
        dto.setMainDiagnosisValidationStatus(stringList.get(index++));
        dto.setMainDiagnosisClinicalStatus(stringList.get(index++));
        dto.setAdditionalDiagnosis(stringList.get(index++));
        dto.setRefutedErrorAdditionalDiagnosis(stringList.get(index++));
        dto.setServiceList(stringList.get(index++));
        dto.setInteractionClass(stringList.get(index++));
        dto.setPriority(stringList.get(index++));
        dto.setInteractionKind(stringList.get(index++));
        dto.setGroundsHospitalization(stringList.get(index++));
        dto.setResultTreatment(stringList.get(index++));
        dto.setPatientID(stringList.get(index++));
        dto.setPresenceDeclaration(Boolean.parseBoolean(stringList.get(index++)));
        dto.setPatientSex(stringList.get(index++));
        dto.setPatientWeight(Float.parseFloat(stringList.get(index++)));
        dto.setPatientAgeDays(Integer.parseInt(stringList.get(index++)));
        dto.setPatientAgeYears(Integer.parseInt(stringList.get(index++)));
        dto.setADSG(stringList.get(index++));
        dto.setServicePackage(stringList.get(index++));
        dto.setServicePackageNumber(stringList.get(index++));
        dto.setTariffUAH(Float.parseFloat(stringList.get(index++)));
        dto.setPaymentFact(stringList.get(index++));
        dto.setStatisticStatus(Boolean.parseBoolean(stringList.get(index++)));
        dto.setReportStatus(Boolean.parseBoolean(stringList.get(index++)));
        dto.setErrorComment(stringList.get(index++));
        dto.setErrorDetails(stringList.get(index++));
        dto.setDetailsRequireVerification(stringList.get(index++));
        dto.setGroupErrorDetails(stringList.get(index++));
        dto.setDetailsPreviewNSZU(stringList.get(index++));
        dto.setAdditionalComment(stringList.get(index++));
        dto.setDatePreviewNSZU(excelHelper.mapToDate(stringList.get(index++)));

//        log.info(dto.toString());
        return dto;
    }

}