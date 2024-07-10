package com.bitam.Telemedicine.Repository;

import com.bitam.Telemedicine.Model.HealthcareProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository


public interface HealthcareProviderRepository extends JpaRepository<HealthcareProvider, Integer> {
}
