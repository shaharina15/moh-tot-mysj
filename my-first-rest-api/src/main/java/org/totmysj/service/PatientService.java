package org.totmysj.service;

import org.totmysj.dto.PatientDto;

public interface PatientService
{
    Long createPatient(PatientDto patient);
    PatientDto getPatient(Long id);
    void deletePatient(Long id);
    void updatePatient(Long id, PatientDto patient);
    PatientDto searchPatientByPatientId(String patientId);
}