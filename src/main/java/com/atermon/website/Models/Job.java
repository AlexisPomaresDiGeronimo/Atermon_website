package com.atermon.website.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Job {
    @Id
    @GeneratedValue(generator="jobs_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="jobs_seq", sequenceName = "jobs_seq", allocationSize = 1)
    public Long jobId;
    public String jobTitle;
    public String jobCompany;
    public LocalDate jobDate;
    @Column(columnDefinition = "LONGTEXT")
    public String jobDescription;
    public String jobLocation;
    public String jobContractType;
    public String jobRemote;
}