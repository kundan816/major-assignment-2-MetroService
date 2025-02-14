package com.example.NammaMetro.Metroservice.entity;

import com.example.NammaMetro.Metroservice.entity.Station;
import com.example.NammaMetro.Metroservice.entity.User;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "check_in_check_out")
public class CheckInCheckOut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference  //  Prevents infinite recursion
    private User user;

    @ManyToOne
    @JoinColumn(name = "station_id")
    private Station station;

    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private boolean checkedOut;
    private Double fare;

    private String qrCode;
}
