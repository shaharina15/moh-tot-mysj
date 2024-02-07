package org.totmysj.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.totmysj.dto.PatientDto;

public interface PatientService
{
    Long createPatient(PatientDto patient);
    @Cacheable(value = "patient")
    PatientDto getPatient(Long id);
    @CacheEvict(value="patient")
    void deletePatient(Long id);
    @CacheEvict(value = "patient", key = "#id")
    void updatePatient(Long id, PatientDto patient);
    PatientDto searchPatientByPatientId(String patientId);
}