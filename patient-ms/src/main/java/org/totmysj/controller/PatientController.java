package org.totmysj.controller;

import org.springframework.web.bind.annotation.*;
import org.totmysj.service.PatientService;
import org.totmysj.dto.PatientDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;

@RestController
class PatientController
{
    //private final PatientRepo patientRepo;
    private final PatientService patientService;

    PatientController(PatientService patientService)
    {
        this.patientService = patientService;
    }

    //private final Map<Integer, Patient> map = new HashMap<>();
    //add record
    @PostMapping("/patient")
    long createPatient(@RequestBody PatientDto patient)
    {
        return patientService.createPatient(patient);
    }
    @GetMapping("/patient/{id}")
    public PatientDto getPatient(@PathVariable("id") Long id)
    {
        return patientService.getPatient(id);
    }
    @DeleteMapping("/patient/{id}")
    public void deletePatient(@PathVariable("id") Long id)
    {
        patientService.deletePatient(id);
    }

    //update data, find by id
    @PostMapping("/patient/{id}")
    public void updatePatient(@PathVariable("id") Long id, @RequestBody PatientDto patient)
    {
        patientService.updatePatient(id, patient);
    }

    //find, search data
    @GetMapping("/patient")
    public PatientDto searchPatientByPatientId(@RequestParam("patientId") String patientId)
    {
        return patientService.searchPatientByPatientId(patientId);
    }
}