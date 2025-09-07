package com.medicure.medicure_service.controller;

import com.medicure.medicure_service.model.Doctor;
import com.medicure.medicure_service.service.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DoctorController {

    private final DoctorService service;

    public DoctorController(DoctorService service) { this.service = service; }

    @PostMapping("/registerDoctor")
    public Doctor registerDoctor(@RequestBody Doctor doctor) {
        return service.registerDoctor(doctor);
    }

    @PutMapping("/updateDoctor/{doctorRegNo}")
    public Doctor updateDoctor(@PathVariable Long doctorRegNo, @RequestBody Doctor doctor) {
        return service.updateDoctor(doctorRegNo, doctor);
    }

    @GetMapping("/searchDoctor/{doctorName}")
    public List<Doctor> searchDoctor(@PathVariable String doctorName) {
        return service.searchByName(doctorName);
    }

    @DeleteMapping("/deleteDoctor/{doctorRegNo}")
    public String deleteDoctor(@PathVariable Long doctorRegNo) {
        service.deleteDoctor(doctorRegNo);
        return "Deleted doctor " + doctorRegNo;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Medicure! ✚";

    }
  
}
