package org.totmysj.service;

import org.springframework.stereotype.Service;
import org.totmysj.domain.PatientEntity;
import org.totmysj.domain.PatientRepo;
import org.totmysj.dto.PatientDto;

@lombok.RequiredArgsConstructor
@Service
class PatientServiceImpl implements PatientService
{
    private final PatientRepo patientRepo;

//    PatientServiceImpl(PatientRepo patientRepo)
//    {
//        this.patientRepo = patientRepo;
//    }
    @Override
    public Long createPatient(PatientDto patient)
    {
        var entity = new PatientEntity();
        entity.setPatientId(patient.getPatientId());
        entity.setAge(patient.getAge());
        entity.setName(patient.getName());
        entity.setContactNo(patient.getContactNo());
        entity.setEmail(patient.getEmail());
        return patientRepo.save(entity).getId();
        //map.put(patientDto.getPatientNo(), patientDto);
    }
    @Override
    public PatientDto getPatient(Long id)
    {
        var entity = patientRepo.findById(id).orElseThrow();
        return new PatientDto(entity.getPatientId(),entity.getName(),entity.getAge(),entity.getContactNo(), entity.getEmail());
    }
    //  patient.setPatientId(entity.getPatientId());
    //  patient.setName(entity.getName());
    //  patient.setAge(entity.getAge());
    //  patient.setContactNo(entity.getContactNo());

    //return map.get(patientId);

    @Override
    public void deletePatient(Long id)
    {
        patientRepo.deleteById(id);
    }

    @Override
    public void updatePatient(Long id, PatientDto patient)
    {
        var entity = patientRepo.findById(id).orElseThrow();

        if (patient.getAge() > 0)
        {
            entity.setAge(patient.getAge());
        }

        if (patient.getName() != null)
        {
            entity.setName(patient.getName());
        }

        if (patient.getPatientId() != null)
        {
            entity.setPatientId(patient.getPatientId());
        }

        if (patient.getContactNo() != null)
        {
            entity.setContactNo(patient.getContactNo());
        }

        if (patient.getEmail() != null)
        {
            entity.setEmail(patient.getEmail());
        }

        patientRepo.save(entity);
    }
    @Override
    public PatientDto searchPatientByPatientId(String patientId)
    {
        var patient = patientRepo.findByPatientId(patientId).orElseThrow();
        return new PatientDto(patient.getPatientId(),patient.getName(),patient.getAge(),patient.getContactNo(),patient.getEmail());
        //return null;
    }
}