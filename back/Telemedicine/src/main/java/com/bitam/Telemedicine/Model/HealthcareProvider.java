package com.bitam.Telemedicine.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class HealthcareProvider {
    @Id
    @GeneratedValue
    public Integer id;
    public String name;
    public String address;
    public String email;
    public String age;

}
