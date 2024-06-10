package com.atermon.website.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity @AllArgsConstructor @NoArgsConstructor
@Data
public class Staff{
    @Id
    @GeneratedValue(generator="staff_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="staff_seq", sequenceName = "staff_seq", allocationSize = 1)
    private Long staffId;
    public String firstname;
    public String lastname;
    public String email;
    public Long phone;
    public String location;
    public LocalDate birthday;
    public int age;
    public int yearsOfExperience;
    @Lob
    private byte[] cv;
}
