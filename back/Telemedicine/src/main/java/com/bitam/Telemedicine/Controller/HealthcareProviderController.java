package com.bitam.Telemedicine.Controller;

import com.bitam.Telemedicine.Model.HealthcareProvider;
import com.bitam.Telemedicine.Services.HealthcareProviderServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/healthcareProvider")

public class HealthcareProviderController {
    @Autowired
    public HealthcareProviderServices healthcareProviderServices;

    @PostMapping("/post-healthcareProvider")
    public HealthcareProvider addHealthcareProvider(@RequestBody HealthcareProvider healthcareProvider){
        return healthcareProviderServices.createHealthcareProvider(healthcareProvider);
    }
    @GetMapping("/get-healthcareProvider")
    public List<HealthcareProvider> findAll(){
        return healthcareProviderServices.findAll();
    }
    @GetMapping("/count-healthcareProvider")
    public long counthealthcareProvider(){
        return healthcareProviderServices.countHealthcareProvider();
    }
    @DeleteMapping("/healthcareProvider/{id}")
    public void updateHealthcareProvider(@PathVariable Integer id){
        healthcareProviderServices.deleteHealthcareProvider(id);
    }
    @PutMapping("/{id}")
    public HealthcareProvider updateHealthcareProvider (@PathVariable int id, @RequestBody HealthcareProvider healthcareProvider){
        return healthcareProviderServices.updateHealthcareProvider(id,healthcareProvider);
    }
    @PutMapping("/update/{id}")
    public HealthcareProvider update(@RequestBody HealthcareProvider healthcareProvider, @PathVariable Integer id){
        healthcareProvider.setId(id);
        return healthcareProviderServices.updateHealthcareProvider(id, healthcareProvider);
    }
}
