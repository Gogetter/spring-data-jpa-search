package dev.etimbuk.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "patients")
@Entity(name = "patients")
public class Patient {
    @Id
    @Column(name = "patient_id")
    private UUID id;

    private String firstName;
    private String lastName;
    private String contactNumber;
    private String email;
    private String address;

    private Character gender;

    private LocalDate dateOfBirth;
    private LocalDate registrationDate;

    @OneToMany(mappedBy = "patient")
    private Set<Appointment> appointments;

    @OneToMany(mappedBy = "patientMedicalRecord")
    private Set<MedicalRecord> medicalRecords;
}
