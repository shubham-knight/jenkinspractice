package com.sapient.globalinsurancesbapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="College")
public class College {
    @Id
    @Column(name="Mobile_No")
    private long collegeId;
    @Column(name="university")
    private String university;
    @Column(name="collegeName")
    private String collegeName;
    @Column(name="address")
    private String address;
    @Column(name="phoneNo")
    private long phoneNo;
    @Column(name="emailId")
    private String emailId;
    @Column(name="website")
    private String website;
    @Column(name="yearOfOpening")
    private String yearOfOpening;

}
