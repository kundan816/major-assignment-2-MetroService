package com.example.NammaMetro.Metroservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "stations")
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;

    @OneToMany(mappedBy = "station", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<CheckInCheckOut> checkIns;

    @OneToOne(mappedBy = "station", cascade = CascadeType.ALL)
    private StationManager manager;
}
