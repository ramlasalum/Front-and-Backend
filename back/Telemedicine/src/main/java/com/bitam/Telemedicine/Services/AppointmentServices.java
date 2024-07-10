package com.bitam.Telemedicine.Services;

import com.bitam.Telemedicine.Model.Appointment;
import com.bitam.Telemedicine.Repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AppointmentServices {
    @Autowired
    public AppointmentRepository appointmentRepository;

    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> findAllAppointments() {
        return appointmentRepository.findAll();
    }

    public long countAppointments() {
        return appointmentRepository.count();
    }

    public void deleteAppointment(Integer id) {
        appointmentRepository.deleteById(id);
    }

    public Appointment updateAppointment(Integer id, Appointment appointment) {
        appointment.setId(id);
        return appointmentRepository.save(appointment);
    }
}
