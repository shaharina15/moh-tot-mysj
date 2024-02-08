package org.totmysj.domain;

import jakarta.persistence.*;

//table structure
@lombok.Data
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@Entity
@Table(name="PATIENT")

public class PatientEntity extends AbstactJpaAuditable<Long>
{

    @Column(name = "PATIENT_ID")
    private String patientId;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CONTACT_NO")
    private String contactNo;

    @Column(name = "EMAIL")
    private String email;
}

//    public void setId(Long id)
//    {
//        this.id = id;
//    }
//
//    public Long getId()
//    {
//        return id;
//    }