package dev.etimbuk.controller;

import dev.etimbuk.dto.StaffAppointmentResponse;
import dev.etimbuk.dto.PersonResponse;
import dev.etimbuk.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = {"/staff"})
public class StaffController {
    private final StaffService staffService;


}
