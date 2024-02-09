package org.totmysj.domain;

import jakarta.persistence.*;
import org.totmysj.domain.AbstactJpaAuditable;

//table structure
@lombok.EqualsAndHashCode(callSuper = true)
@lombok.Data
@Entity
@Table(name="PATIENT", indexes = @Index(unique = true, columnList = "PATIENT_ID"))

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