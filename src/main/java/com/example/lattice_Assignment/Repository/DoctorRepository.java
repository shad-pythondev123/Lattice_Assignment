package com.example.lattice_Assignment.Repository;

import com.example.lattice_Assignment.Model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
 public Doctor findByEmail(String email);
}
