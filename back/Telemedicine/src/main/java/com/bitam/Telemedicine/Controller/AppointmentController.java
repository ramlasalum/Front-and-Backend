package com.bitam.Telemedicine.Controller;

import com.bitam.Telemedicine.Model.Appointment;
import com.bitam.Telemedicine.Services.AppointmentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentServices appointmentServices;

    @PostMapping("/create")
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentServices.createAppointment(appointment);
    }

    @GetMapping("/getAll")
    public List<Appointment> getAllAppointments() {
        return appointmentServices.findAllAppointments();
    }

    @GetMapping("/count")
    public long countAppointments() {
        return appointmentServices.countAppointments();
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Integer id) {
        appointmentServices.deleteAppointment(id);
    }

    @PutMapping("/{id}")
    public Appointment updateAppointment(@PathVariable Integer id, @RequestBody Appointment appointment) {
        return appointmentServices.updateAppointment(id, appointment);
    }
}
