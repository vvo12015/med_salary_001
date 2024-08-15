package net.vrakin.med_salary.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "nszu_decryption")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class NSZU_Decryption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int year;

    private int month;

    @Column(name = "record_kind", length = 255)
    private String recordKind;

    @Column(name = "record_id", length = 255)
    private String recordID;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "executor_user_position", length = 255)
    private String executorUserPosition;

    @Column(name = "executor_name", length = 255)
    private String executorName;

    @Column(name = "provider_place", length = 255)
    private String providerPlace;

    @Column(name = "referral_kind", length = 255)
    private String referralKind;

    @Column(name = "edrpou", length = 255)
    private String EDRPOU;

    @Column(name = "referring_user_position", length = 255)
    private String referringUserPosition;

    @Column(name = "episode_id", length = 255)
    private String episodeId;

    @Column(name = "episode_kind", length = 255)
    private String episodeKind;

    @Column(name = "episode_start_date")
    private LocalDateTime episodeStartDate;

    @Column(name = "period_start_date")
    private LocalDateTime periodStartDate;

    @Column(name = "period_end_date")
    private LocalDateTime periodEndDate;

    @Column(name = "period_lenght")
    private int periodLength;

    @Column(name = "main_diagnosis", length = 255)
    private String mainDiagnosis;

    @Column(name = "main_diagnosis_validation_status", length = 255)
    private String mainDiagnosisValidationStatus;

    @Column(name = "main_diagnosis_clinical_status", length = 255)
    private String mainDiagnosisClinicalStatus;

    @Column(name = "additional_diagnosis", length = 255)
    private String additionalDiagnosis;

    @Column(name = "refuted_error_additional_diagnosis", length = 255)
    private String refutedErrorAdditionalDiagnosis;

    @Column(name = "service_list", length = 255)
    private String serviceList;

    @Column(name = "interaction_class", length = 255)
    private String interactionClass;

    @Column(name = "priority", length = 255)
    private String priority;

    @Column(name = "interaction_kind", length = 255)
    private String interactionKind;

    @Column(name = "grounds_hospitalization", length = 255)
    private String groundsHospitalization;

    @Column(name = "result_treatment", length = 255)
    private String resultTreatment;

    @Column(name = "patient_id", length = 255)
    private String patientID;

    @Column(name = "presence_declaration")
    private Boolean presenceDeclaration;

    @Column(name = "patient_sex", length = 255)
    private String patientSex;

    @Column(name = "patient_weight")
    private float patientWeight;

    @Column(name = "patient_age_days")
    private int patientAgeDays;

    @Column(name = "patient_age_years")
    private int patientAgeYears;

    @Column(name = "adsg", length = 255)
    private String ADSG;

    @Column(name = "service_package", length = 255)
    private String servicePackage;

    @Column(name = "service_package_number", length = 255)
    private String servicePackageNumber;

    @Column(name = "tariff_uah")
    private float tariffUAH;

    @Column(name = "payment_fact", length = 255)
    private String paymentFact;

    @Column(name = "statistic_status")
    private boolean statisticStatus;

    @Column(name = "report_status")
    private boolean reportStatus;

    @Column(name = "error_comment", length = 255)
    private String errorComment;

    @Column(name = "error_details", length = 255)
    private String errorDetails;

    @Column(name = "details_require_verification", length = 255)
    private String detailsRequireVerification;

    @Column(name = "group_error_details", length = 255)
    private String groupErrorDetails;

    @Column(name = "details_preview_nszu", length = 255)
    private String detailsPreviewNSZU;

    @Column(name = "additional_comment", length = 255)
    private String additionalComment;

    @Column(name = "date_preview_nszu")
    private LocalDateTime datePreviewNSZU;

    @Override
    public String toString() {
        return "NszuDecryption{" +
                "id=" + id +
                ", year=" + year +
                ", month=" + month +
                ", recordKind='" + recordKind + '\'' +
                ", recordID='" + recordID + '\'' +
                ", creationDate=" + creationDate +
                ", executorUserPosition='" + executorUserPosition + '\'' +
                ", executorName='" + executorName + '\'' +
                ", providerPlace='" + providerPlace + '\'' +
                ", referralKind='" + referralKind + '\'' +
                ", EDRPOU='" + EDRPOU + '\'' +
                ", referringUserPosition='" + referringUserPosition + '\'' +
                ", episodeId='" + episodeId + '\'' +
                ", episodeKind='" + episodeKind + '\'' +
                ", episodeStartDate=" + episodeStartDate +
                ", periodStartDate=" + periodStartDate +
                ", periodEndDate=" + periodEndDate +
                ", periodLength=" + periodLength +
                ", mainDiagnosis='" + mainDiagnosis + '\'' +
                ", mainDiagnosisValidationStatus='" + mainDiagnosisValidationStatus + '\'' +
                ", mainDiagnosisClinicalStatus='" + mainDiagnosisClinicalStatus + '\'' +
                ", additionalDiagnosis='" + additionalDiagnosis + '\'' +
                ", refutedErrorAdditionalDiagnosis='" + refutedErrorAdditionalDiagnosis + '\'' +
                ", serviceList='" + serviceList + '\'' +
                ", interactionClass='" + interactionClass + '\'' +
                ", priority='" + priority + '\'' +
                ", interactionKind='" + interactionKind + '\'' +
                ", groundsHospitalization='" + groundsHospitalization + '\'' +
                ", resultTreatment='" + resultTreatment + '\'' +
                ", patientID='" + patientID + '\'' +
                ", presenceDeclaration=" + presenceDeclaration +
                ", patientSex='" + patientSex + '\'' +
                ", patientWeight=" + patientWeight +
                ", patientAgeDays=" + patientAgeDays +
                ", patientAgeYears=" + patientAgeYears +
                ", ADSG='" + ADSG + '\'' +
                ", servicePackage='" + servicePackage + '\'' +
                ", servicePackageNumber='" + servicePackageNumber + '\'' +
                ", tariffUAH=" + tariffUAH +
                ", paymentFact='" + paymentFact + '\'' +
                ", statisticStatus=" + statisticStatus +
                ", reportStatus=" + reportStatus +
                ", errorComment='" + errorComment + '\'' +
                ", errorDetails='" + errorDetails + '\'' +
                ", detailsRequireVerification='" + detailsRequireVerification + '\'' +
                ", groupErrorDetails='" + groupErrorDetails + '\'' +
                ", detailsPreviewNSZU='" + detailsPreviewNSZU + '\'' +
                ", additionalComment='" + additionalComment + '\'' +
                ", datePreviewNSZU=" + datePreviewNSZU +
                '}';
    }
}
