package net.vrakin.med_salary.dto;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class NSZUDecryptionDTO {

    private Long id;

    private int year;

    private int month;

    private String recordKind;

    private String recordID;

    private LocalDateTime creationDate;

    private String executorUserPosition;

    private String executorName;

    private String providerPlace;

    private String referralKind;

    @Getter(onMethod_ = {@JsonGetter("EDRPOU")})
    @Setter(onMethod_ = {@JsonSetter("EDRPOU")})
    private String EDRPOU;

    private String referringUserPosition;

    private String episodeId;

    private String episodeKind;

    private LocalDateTime episodeStartDate;

    private LocalDateTime periodStartDate;

    private LocalDateTime periodEndDate;

    private int periodLength;

    private String mainDiagnosis;

    private String mainDiagnosisValidationStatus;

    private String mainDiagnosisClinicalStatus;

    private String additionalDiagnosis;

    private String refutedErrorAdditionalDiagnosis;

    private String serviceList;

    private String interactionClass;

    private String priority;

    private String interactionKind;

    private String groundsHospitalization;

    private String resultTreatment;

    private String patientID;

    private Boolean presenceDeclaration;

    private String patientSex;

    private float patientWeight;

    private int patientAgeDays;

    private int patientAgeYears;

    @Getter(onMethod_ = {@JsonGetter("ADSG")})
    @Setter(onMethod_ = {@JsonSetter("ADSG")})
    private String ADSG;

    private String servicePackage;

    private String servicePackageNumber;

    private float tariffUAH;

    private String paymentFact;

    private boolean statisticStatus;

    private boolean reportStatus;

    private String errorComment;

    private String errorDetails;

    private String detailsRequireVerification;

    private String groupErrorDetails;

    private String detailsPreviewNSZU;

    private String additionalComment;

    private LocalDateTime datePreviewNSZU;

}
