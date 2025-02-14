package com.example.NammaMetro.Metroservice.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String metroCardNumber;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference  //  Prevents infinite recursion
    private List<CheckInCheckOut> checkIns;
}
