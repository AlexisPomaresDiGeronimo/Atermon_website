package com.atermon.website.Models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @NoArgsConstructor @AllArgsConstructor
public class ContactSender{
    @Id
    @GeneratedValue(generator="contactUs_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="contactUs_seq", sequenceName = "contactUs_seq", allocationSize = 1)
    public Long contactUsId;
    public String firstname;
    public String lastname;
    public String email;
    public Long phone;
    public String message;
}