package com.example.lattice_Assignment.Controllor;

import com.example.lattice_Assignment.Exception.EntityAreadyExistsException;
import com.example.lattice_Assignment.Exception.EntityNotFoundException;
import com.example.lattice_Assignment.Model.Patient;
import com.example.lattice_Assignment.Service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Validated
@RestController
@RequestMapping("/Patient")
public class PatientController {
    @Autowired
    PatientService patientService;
    @PostMapping("/addPatient")
    public ResponseEntity<String> addPatient(@Valid @RequestBody Patient patient){
        try{
            patientService.addPatient(patient);
            return ResponseEntity.ok("Patient Added Successfully!");
        }
        catch(EntityAreadyExistsException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
    @DeleteMapping("/deletePatient")
    public ResponseEntity<String> deletePatient(@RequestParam int id){
        try{
            patientService.deletePatient(id);
            return ResponseEntity.ok("Patient Deleted Successfully!");
        }
        catch(EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
