package org.totmysj.controller;

import org.totmysj.Main;
import org.totmysj.commons.utils.JsonUtils;
import org.totmysj.domain.PatientRepo;
import org.totmysj.dto.PatientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK, classes = Main.class, properties = {
        "spring.datasource.url=jdbc:h2:mem:db0",
        "spring.datasource.username=sa",
        "spring.datasource.password="
})
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class PatientControlIntegrationTest
{
    @Autowired
    private MockMvc mvc;
    @Autowired
    private PatientRepo patientRepo;
    //private PatientDto patient = new PatientDto("678-9023-2024", "Suhana", 20, "019-52147369", "hamid@test.my");

    @Test
    @Order(1)
    void testCreatePatient() throws Exception
    {
        var patient = new PatientDto("9087-0911-2024","Nadira",35,"013-8574123","nadira@test.com");
        mvc.perform(post("/patient")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtils.objToString(patient)))
                .andExpect(result ->
                {
                    assertEquals(200, result.getResponse().getStatus());
                    assertEquals("1", result.getResponse().getContentAsString());
                    assertEquals("nadira@test.com", patientRepo.findById(1L).orElseThrow().getEmail());
                });
    }

    @Test
    @Order(2)
    void testGetPatient() throws Exception
    {
        var patient = new PatientDto("9087-0911-2024","Nadira",35,"013-8574123","nadira@test.com");
        mvc.perform(post("/patient").accept(MediaType.APPLICATION_JSON))
                .andExpect(result -> {
                    assertEquals(200,result.getResponse().getStatus());
                    assertEquals(patient, JsonUtils.stringToObj(result.getResponse().getContentAsString(),
                            PatientDto.class));
                });
    }

    @Test
    @Order(3)
    void testUpdatePatient() throws Exception
    {
        var modifiedPatient = new PatientDto("9087-0911-2024","Nadira",35,"013-8574123","nadira@test.com");
        modifiedPatient.setEmail("nadira90@test.com");
        mvc.perform(post("patient/2")
                .contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtils.objToString(modifiedPatient)))
                .andExpect(result ->
                {
                    assertEquals(200, result.getResponse().getStatus());
                    assertEquals("", result.getResponse().getContentAsString());

                    var p = patientRepo.findById(1L).orElseThrow();

                    assertEquals("nadira90@test.com", p.getEmail());
                    assertEquals("9087-0911-2024", p.getPatientId());
                    assertEquals("Nadira", p.getName());
                    assertEquals(35, p.getAge());
                    assertEquals("013-8574123", p.getContactNo());
                });
    }

    @Test
    @Order(4)
    void testDeletePatient() throws Exception
    {
        mvc.perform(delete("/patient/2"))
                .andExpect(result ->
                {
                    assertEquals(200, result.getResponse().getStatus());
                    assertTrue(patientRepo.findAll().isEmpty());
                });
    }
}