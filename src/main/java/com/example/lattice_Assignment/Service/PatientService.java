package com.example.lattice_Assignment.Service;

import com.example.lattice_Assignment.Exception.EntityAreadyExistsException;
import com.example.lattice_Assignment.Exception.EntityNotFoundException;
import com.example.lattice_Assignment.Model.Doctor;
import com.example.lattice_Assignment.Model.Patient;
import com.example.lattice_Assignment.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientService {
@Autowired
    PatientRepository patientRepository;
public Patient addPatient(Patient patient){
    Patient patient1= patientRepository.findByEmail(patient.getEmail());
    if (patient1!=null) {
        throw new EntityAreadyExistsException("Patient Already Present");
    }
    return patientRepository.save(patient);
}
public String deletePatient(int id){
    Optional<Patient> patient1 = patientRepository.findById(id);
    if (patient1.isEmpty()) {
        throw new EntityNotFoundException("Patient not Found!");
    }
    patientRepository.delete(patient1.get());
    return "Patient deleted Successfully";
}
}
