package dev.etimbuk.service;

import dev.etimbuk.dto.StaffAppointmentResponse;
import dev.etimbuk.dto.StaffResponse;
import dev.etimbuk.mapper.StaffResponseMapper;
import dev.etimbuk.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class StaffService {
    private final StaffRepository staffRepository;
    private final StaffResponseMapper staffResponseMapper;

    public Optional<StaffResponse> findStaffByEmail(final String email) {
        return staffRepository.findByEmail(email).map(staffResponseMapper::to);
    }

    public List<StaffResponse> findAllByPositionAndHireDateBetween(final String position, final LocalDate startDate, final LocalDate endDate) {
        return staffRepository.findAllByPositionAndHireDateBetween(position, startDate, endDate)
                .stream()
                .map(staffResponseMapper::to)
                .toList();
    }

    public List<StaffResponse> findAllByFirstNameStartingWith(final String firstName) {
        return staffRepository.findAllByFirstNameStartingWith(firstName).stream().map(staffResponseMapper::to).toList();
    }

    public List<StaffResponse> findAllByFirstNameStartingWithIgnoreCase(final String firstName) {
        return staffRepository.findAllByFirstNameStartingWithIgnoreCase(firstName).stream().map(staffResponseMapper::to).toList();
    }

    public List<StaffAppointmentResponse> findStaffByAppointmentDate(final LocalDateTime appointmentDate) {
//        return staffRepository.findAllByAppointments_AppointmentDate(appointmentDate);
        return staffRepository.findAllStaffByAppointmentDate(appointmentDate);
    }
}
