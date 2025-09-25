package dev.etimbuk.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "appointments")
@Entity(name = "appointments")
public class Appointment {
    @Id
    @Column(name = "appointment_id")
    private UUID id;

    private String status;
    private String appointmentReason;
    private LocalDateTime appointmentDate;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staffAppointment;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
}
