package com.bitam.Telemedicine.Services;

import com.bitam.Telemedicine.Model.Patient;
import com.bitam.Telemedicine.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PatientServices {
    public static int addPatient;
    @Autowired
    public PatientRepository patientRepository;

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    public long countPatient() {
        return patientRepository.count();
    }

    public void deletePatient(Integer id) {
        patientRepository.deleteById(id);
    }

    public Patient updatePatient(Integer id, Patient patient) {
        patient.setId(id);
        return patientRepository.save(patient);

    }

}
