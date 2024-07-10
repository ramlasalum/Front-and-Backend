package com.bitam.Telemedicine.Controller;

import com.bitam.Telemedicine.Model.Patient;
import com.bitam.Telemedicine.Services.PatientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/patient")
@CrossOrigin("*")

public class PatientController {
    @Autowired
    public PatientServices patientServices;

    @PostMapping("/post-patient")
    public Patient addPatient(@RequestBody Patient patient){
        return patientServices.createPatient(patient);
    }

    @GetMapping("/get-patient")
    public List<Patient> findAll(){
        return patientServices.findAll();
    }
    @GetMapping("/count-patient")
    public long countPatient(){
        return patientServices.countPatient();
    }
    @DeleteMapping("/patient/{id}")
    public void deletePatient(@PathVariable Integer id){
        patientServices.deletePatient(id);
    }
    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable Integer id ,@RequestBody Patient patient){
        return patientServices.updatePatient(id, patient);
    }
    @PutMapping("/update/{id}")
    public Patient update(@RequestBody Patient patient, @PathVariable Integer id){
        patient.setId(id);
        return patientServices.updatePatient(id, patient);

    }


}



