package com.atermon.website.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Candidate {
    @Id
    @GeneratedValue(generator="candidates_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="candidates_seq", sequenceName = "candidates_seq", allocationSize = 1)
    public Long candidateId;
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
