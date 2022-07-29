package com.sapient.globalinsurancesbapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rollNo")
    private long rollNo;
    @Column(name="email",nullable = false)
    private String email;
    @Column(name="phoneNo",length = 25,nullable = false)
    private Long phoneNo;
    @Column(name="address",length = 25,nullable = false)
    private String  address;
    @Column(name="semester",length = 15,nullable = false)
    private String semester;
    @Column(name="dept")
    private String dept;
    @Column(name="remarks",length = 15,nullable = false)
    private String remarks;
    @ManyToOne
    @JoinColumn(name = "address",foreignKey = @ForeignKey(name = "address"))
    private College college;

}
