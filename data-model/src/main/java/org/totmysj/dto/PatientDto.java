//dto - dta transfer object
package org.totmysj.dto;

@lombok.Data
@lombok.AllArgsConstructor

public class PatientDto
{
    private String patientId;
    private String name;
    private int age;
    private String contactNo;
    private String email;
}

//getter & setter
//    public String getPatientId() { return patientId; }
//    public void setPatientId(String patientId) { this.patientId = patientId; }
//
//    public String getName() { return name; }
//    public void setName(String name) { this.name = name; }
//
//    public int getAge() { return age; }
//    public void setAge(int age) { this.age = age;
//    }
//    public String getContactNo() { return contactNo; }
//    public void setContactNo(String contactNo) { this.contactNo = contactNo; }