package org.totmysj.controller;

import org.junit.jupiter.api.Test;
import org.totmysj.commons.utils.JsonUtils;
import org.totmysj.dto.PatientDto;
import org.totmysj.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(value = PatientController.class)
class PatientControllerTest
{
    @MockBean
    private PatientService patientService;
    @Autowired
    private MockMvc mvc;

    @Test
    void testCreatePatient() throws Exception
    {
        var patient = new PatientDto("020901-01-0101","Hamzah",52,"","");
        mvc.perform(post("/patient")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.objToString(patient)))
                .andExpect(result ->
                {
                    assertEquals(200, result.getResponse().getStatus());
                    assertEquals("1", result.getResponse().getContentAsString());
                    verify(patientService, times(1)).createPatient(patient);
                });
    }
}
