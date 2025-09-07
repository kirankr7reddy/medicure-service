package com.medicure.medicure_service.service;

import com.medicure.medicure_service.model.Doctor;
import com.medicure.medicure_service.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository repo;

    public DoctorService(DoctorRepository repo) { this.repo = repo; }

    public Doctor registerDoctor(Doctor d) {
        return repo.save(d);
    }

    public Doctor updateDoctor(Long regNo, Doctor updated) {
        Doctor existing = repo.findById(regNo)
                .orElseThrow(() -> new RuntimeException("Doctor not found: " + regNo));
        existing.setDoctorName(updated.getDoctorName());
        existing.setSpecialization(updated.getSpecialization());
        existing.setContact(updated.getContact());
        return repo.save(existing);
    }

    public List<Doctor> searchByName(String name) {
        return repo.findByDoctorNameContainingIgnoreCase(name);
    }

    public void deleteDoctor(Long regNo) {
        repo.deleteById(regNo);
    }
}
