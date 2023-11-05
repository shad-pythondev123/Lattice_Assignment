package com.example.lattice_Assignment.Controllor;

import com.example.lattice_Assignment.Exception.EntityAreadyExistsException;
import com.example.lattice_Assignment.Exception.EntityNotFoundException;
import com.example.lattice_Assignment.Model.Doctor;
import com.example.lattice_Assignment.Service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
//@Validated
@RequestMapping("/Doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @PostMapping("/addDoctor")
    public ResponseEntity<String> addDoctor( @Valid @RequestBody Doctor doctor){
        try{
            doctorService.addDoctor(doctor);
            return ResponseEntity.ok("Doctor Added Successfully!");
        }
        catch(EntityAreadyExistsException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @DeleteMapping("/deleteDoctor")
    public ResponseEntity<String> deleteDoctor(@RequestParam int id){
        try{
            doctorService.deleteDoctor(id);
            return ResponseEntity.ok("Doctor Deleted Successfully!");
        }
        catch(EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/suggest-doctors")
    public ResponseEntity<Object> suggestDoctors(@RequestParam int patientId){
        return doctorService.suggestDoctors(patientId);

    }
}
