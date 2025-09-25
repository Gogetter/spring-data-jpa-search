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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "medical_records")
@Entity(name = "medical_records")
public class MedicalRecord {
    @Id
    @Column(name = "record_id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patientMedicalRecord;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staffAuthoredMedicalRecord;
}
