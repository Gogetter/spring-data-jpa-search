package dev.etimbuk.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "staff")
@Entity(name = "staff")
public class Staff {
    @Id
    @Column(name = "staff_id")
    private UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "position")
    private String position;

    @Column(name = "contact_number")
    private String contactNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "hire_date")
    private LocalDate hireDate;

    @OneToMany(mappedBy = "staffAppointment")
    private Set<Appointment> appointments;

    @OneToMany(mappedBy = "staffAuthoredMedicalRecord")
    private Set<MedicalRecord> medicalRecords;
}
