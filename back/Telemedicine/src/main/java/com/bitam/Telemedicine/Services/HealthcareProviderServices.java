package com.bitam.Telemedicine.Services;

import com.bitam.Telemedicine.Model.HealthcareProvider;
import com.bitam.Telemedicine.Repository.HealthcareProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class HealthcareProviderServices {
    @Autowired
    public HealthcareProviderRepository healthcareProviderRepository;

    public HealthcareProvider createHealthcareProvider(HealthcareProvider healthcareProvider) {
        return healthcareProviderRepository.save(healthcareProvider);
    }

    public List<HealthcareProvider> findAll() {
        return healthcareProviderRepository.findAll();
    }

    public long countHealthcareProvider() {
        return healthcareProviderRepository.count();
    }

    public void deleteHealthcareProvider(Integer id) {
        healthcareProviderRepository.deleteById(id);
    }

    public HealthcareProvider updateHealthcareProvider(int id, HealthcareProvider healthcareProvider) {
        healthcareProvider.setId(id);
        return healthcareProviderRepository.save(healthcareProvider);

    }
}
