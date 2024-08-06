package net.vrakin.med_salary.exception;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDetails {
    private LocalDate timestamp;
    private String message;
    private String path;
    private String errorCode;
}
