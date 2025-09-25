package dev.etimbuk.repository;

import dev.etimbuk.SQLSelect;
import dev.etimbuk.dto.StaffAppointmentResponse;
import dev.etimbuk.models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository //optional given we have extended @JpaRepository
public interface StaffRepository extends JpaRepository<Staff, UUID> {
    Optional<Staff> findByEmail(String email);
    List<Staff> findAllByFirstNameStartingWith(String firstName);
    List<Staff> findAllByFirstNameStartingWithIgnoreCase(String firstName);
    List<Staff> findAllByPositionAndHireDateBetween(String position, LocalDate startDate, LocalDate endDate);
    List<Staff> findAllByEmailContainingIgnoreCaseAndFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(String email, String firstName, String lastName);

    List<StaffAppointmentResponse> findAllByAppointments_AppointmentDate(LocalDateTime appointmentDate);

    @Query(value = SQLSelect.JPQL_GET_STAFF_BY_APPOINTMENT_DATE)
    List<StaffAppointmentResponse> findAllStaffByAppointmentDate(@Param("appointmentDate") LocalDateTime appointmentDate);
}
