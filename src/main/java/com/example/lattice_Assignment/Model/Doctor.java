package com.example.lattice_Assignment.Model;

import com.example.lattice_Assignment.Enum.DoctorCity;
import com.example.lattice_Assignment.Enum.DoctorSpeciality;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int Id;
    @Size(min=3)

    @Column(nullable = false)
    String name;
    @Enumerated(EnumType.STRING)
    DoctorCity doctorCity;
    @Enumerated(EnumType.STRING)
    DoctorSpeciality speciality;

    @Email
    @Column(unique = true)
    String email;
    @Size(min=10)
    @Column(unique = true)
    String phone;
}
