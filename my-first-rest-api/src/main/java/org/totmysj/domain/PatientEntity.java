package org.totmysj.domain;

import jakarta.persistence.*;

//table structure
@Entity
@Table(name="PATIENT")

public class PatientEntity extends AbstactJpaAuditable<Long>
{
//    @Id
//    @GeneratedValue
//    private Long id;

    @Column(name = "PATIENT_ID")
    private String patientId;

    @Column(name="AGE")
    private Integer age;

    @Column(name="NAME")
    private String name;

//    public void setId(Long id)
//    {
//        this.id = id;
//    }
//
//    public Long getId()
//    {
//        return id;
//    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
