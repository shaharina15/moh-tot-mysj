package org.totmysj.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

//table structure
@Setter
@Getter
@Entity
@Table(name="PATIENT")

public class PatientEntity extends AbstactJpaAuditable<Long>
{
//    @Id
//    @GeneratedValue
//    private Long id;

    @Column(name = "PATIENT_ID")
    private String patientId;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CONTACT_NO")
    private String contactNo;
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