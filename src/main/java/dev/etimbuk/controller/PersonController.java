package dev.etimbuk.controller;

import dev.etimbuk.dto.PersonResponse;
import dev.etimbuk.dto.StaffAppointmentResponse;
import dev.etimbuk.service.PatientService;
import dev.etimbuk.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PersonController {
    private final StaffService staffService;
    private final PatientService patientService;

    @GetMapping("/staff")
    public ResponseEntity<PersonResponse> getStaff(final String staffEmail) {
        return staffService.findStaffByEmail(staffEmail)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/staff/appointment")
    public ResponseEntity<List<StaffAppointmentResponse>> getStaffAppointments(final String appointmentDate) {
        return ResponseEntity.ofNullable(staffService.findStaffByAppointmentDate(LocalDateTime.parse(appointmentDate)));
    }

    @GetMapping("/patient")
    public ResponseEntity<List<PersonResponse>> getPatient(final String search) {
        return
//            Optional.of(patientService.findAllPatientsByFirstName(firstName))
            Optional.of(patientService.findAllPatientsByEmailAddress(search))
//            Optional.of(patientService.findAllPatients(search))
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
