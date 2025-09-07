package com.medicure.medicure_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DOCTOR")
public class Doctor {

    @Id
    private Long doctorRegNo;
    private String doctorName;
    private String specialization;
    private String contact;

    public Doctor() {}

    public Long getDoctorRegNo() { return doctorRegNo; }
    public void setDoctorRegNo(Long doctorRegNo) { this.doctorRegNo = doctorRegNo; }

    public String getDoctorName() { return doctorName; }
    public void setDoctorName(String doctorName) { this.doctorName = doctorName; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
}

