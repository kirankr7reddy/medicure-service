package com.medicure.medicure_service.repository;

import com.medicure.medicure_service.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findByDoctorNameContainingIgnoreCase(String name);
}
