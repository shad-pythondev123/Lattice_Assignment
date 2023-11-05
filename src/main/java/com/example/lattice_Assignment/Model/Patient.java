package com.example.lattice_Assignment.Model;

import com.example.lattice_Assignment.Enum.PatientSymptom;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int Id;
    @Size(min=3)
    @Column(nullable = false)
    String name;
    @Size(max=20)
    String city;
    @Enumerated(EnumType.STRING)
    PatientSymptom symptom;

    @Email
    @Column(unique = true)
    String email;
    @Size(min=10)
    @Column(unique = true)
    String phone;
}
