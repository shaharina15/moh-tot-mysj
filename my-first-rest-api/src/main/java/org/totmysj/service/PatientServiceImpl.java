package org.totmysj.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.totmysj.domain.PatientEntity;
import org.totmysj.domain.PatientRepo;
import org.totmysj.dto.PatientDto;

@Service
class PatientServiceImpl implements PatientService
{
    private final PatientRepo patientRepo;

    PatientServiceImpl(PatientRepo patientRepo)
    {
        this.patientRepo = patientRepo;
    }
    @Override
    public Long createPatient(PatientDto patient)
    {
        var entity = new PatientEntity();
        entity.setPatientId(patient.getPatientId());
        entity.setAge(patient.getAge());
        entity.setName(patient.getName());
        return patientRepo.save(entity).getId();
        //map.put(patientDto.getPatientNo(), patientDto);
    }
    public PatientDto getPatient(@PathVariable("id") Long id)
    {
        var entity = patientRepo.findById(id).orElseThrow();
        var patient = new PatientDto();
        patient.setPatientId(entity.getPatientId());
        patient.setName(entity.getName());
        patient.setAge(entity.getAge());
        return patient;
        //return map.get(patientId);
    }

    @Override
    public void deletePatient(Long id)
    {
        patientRepo.deleteById(id);
    }

    @Override
    public void updatePatient(Long id, PatientDto patient)
    {
        var entity = patientRepo.findById(id).orElseThrow();

        entity.setAge(patient.getAge());
        entity.setName(patient.getName());
        entity.setPatientId(patient.getPatientId());
        patientRepo.save(entity);
    }
    @Override
    public PatientDto searchPatientByPatientId(String patientId)
    {
        var patient = patientRepo.findByPatientId(patientId).orElseThrow();
        return new PatientDto();
        //return null;
    }
}