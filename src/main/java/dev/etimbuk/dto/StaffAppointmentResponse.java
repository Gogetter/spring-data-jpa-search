package dev.etimbuk.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class StaffAppointmentResponse {
    private String firstName;
    private String lastName;
    private String position;
    private String appointmentsStatus;
    private String appointmentsAppointmentReason;
    private LocalDateTime appointmentsAppointmentDate;
}
