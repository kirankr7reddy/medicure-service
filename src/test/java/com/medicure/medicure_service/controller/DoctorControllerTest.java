package com.medicure.medicure_service.controller;

import com.medicure.medicure_service.model.Doctor;
import com.medicure.medicure_service.service.DoctorService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;   
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DoctorController.class)
class DoctorControllerTest {

    @Autowired
    private MockMvc mvc;

    @SuppressWarnings("removal")   
    @MockBean
    private DoctorService service;

    @Test
    void testSearchDoctor() throws Exception {
        Doctor d = new Doctor();
        d.setDoctorRegNo(2001L);
        d.setDoctorName("John");

        Mockito.when(service.searchByName("John"))
               .thenReturn(Collections.singletonList(d));

        mvc.perform(get("/api/searchDoctor/John"))
           .andExpect(status().isOk())
           .andExpect(jsonPath("$[0].doctorRegNo").value(2001))
           .andExpect(jsonPath("$[0].doctorName").value("John"));
    }
}




