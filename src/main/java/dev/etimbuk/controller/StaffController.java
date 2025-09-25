package dev.etimbuk.controller;

import dev.etimbuk.dto.StaffAppointmentResponse;
import dev.etimbuk.dto.StaffResponse;
import dev.etimbuk.models.Staff;
import dev.etimbuk.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = {"/staff"})
public class StaffController {
    private final StaffService staffService;

    @GetMapping
    public ResponseEntity<StaffResponse> getStaff(final String staffEmail) {
        return staffService.findStaffByEmail(staffEmail)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/appointment")
    public ResponseEntity<List<StaffAppointmentResponse>> getStaffAppointments(final String appointmentDate) {
        return ResponseEntity.ofNullable(staffService.findStaffByAppointmentDate(LocalDateTime.parse(appointmentDate)));
    }
}
