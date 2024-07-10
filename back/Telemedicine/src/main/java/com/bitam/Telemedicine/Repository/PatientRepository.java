package com.bitam.Telemedicine.Repository;

import com.bitam.Telemedicine.Model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
