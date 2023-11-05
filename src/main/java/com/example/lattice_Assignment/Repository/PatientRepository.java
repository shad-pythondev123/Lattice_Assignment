package com.example.lattice_Assignment.Repository;

import com.example.lattice_Assignment.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
public Patient findByEmail(String email);
}
