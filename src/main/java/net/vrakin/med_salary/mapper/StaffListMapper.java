package net.vrakin.med_salary.mapper;

import net.vrakin.med_salary.dto.*;
import net.vrakin.med_salary.domain.StaffList;
import net.vrakin.med_salary.excel.ExcelHelper;
import org.mapstruct.Mapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class StaffListMapper implements BaseMapper<StaffList, StaffListDTO> {
    public static final int INDEX_STAFF_LIST_ID = 0;
    public static final int INDEX_USER_POSITION_CODE = 1;
    public static final int INDEX_USER_POSITION_NAME = 2;
    public static final int INDEX_DEPARTMENT_NAME = 3;
    public static final int INDEX_EMPLOYMENT = 4;
    public static final int INDEX_IPN = 5;
    private ExcelHelper excelHelper;

    @Mapping(target = "IPN", source = "IPN")
    public abstract StaffListDTO toDto(StaffList entity);

    /*
       private Id id;
       private StaffListId staffListId;
       private User user;
       private UserPosition userPosition;
       private Employment employment;
       private MaxPoint maxPoint;
       private PointValue pointValue;
       private Department department;
       private IPN IPN;
       private CreationDate creationDate;
       private StartDate startDate;
       private EndDate endDate;
        */
    public StaffListDTO toDto(String stringDTO) {

        List<String> stringList = Arrays.stream(stringDTO.split("&&"))
                .collect(Collectors.toList());

        stringList = stringList.stream().map(s->{
            if (s.equals(ExcelHelper.EMPTY_SING_EXCEL)) {
                return ExcelHelper.EMPTY_SING;
            }
            return s;
        }).toList();

        StaffListDTO dto = new StaffListDTO();
        int index = 0;
        dto.setStaffListId(stringList.get(INDEX_STAFF_LIST_ID));
        UserPositionDTO userPositionDTO = new UserPositionDTO();
        userPositionDTO.setUserPositionCodeIdPro(stringList.get(INDEX_USER_POSITION_CODE));
        userPositionDTO.setName(stringList.get(INDEX_USER_POSITION_NAME));
        dto.setUserPosition(userPositionDTO);
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setName(stringList.get(INDEX_DEPARTMENT_NAME));
        dto.setDepartment(departmentDTO);
        dto.setEmployment(Float.parseFloat(stringList.get(INDEX_EMPLOYMENT)));
        dto.setIPN(stringList.get(INDEX_IPN));
        dto.
        dto.setUser();
        dto.setStaffListId(stringList.get(index++));
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
