package com.atermon.website.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class  User  {
        @Id
        @GeneratedValue(generator="staff_seq", strategy = GenerationType.SEQUENCE)
        @SequenceGenerator(name="staff_seq", sequenceName = "staff_seq", allocationSize = 1)
        private Long userId;    private String username;
        private String password;
        private String role;     //ROLE_ + name <-- save database
        //    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
        //    private List<Message> messages
}
