package main.java.com.example.travel_agency.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name="vacation")
@Getter
@Setter
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="vacation_title")
    private String vacationTitle;

    @Column(name="description")
    private String description;

    @Column(name="travel_fare")
    private BigDecimal travelFare;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vacation")
    private Set<Excursion> excursions;
}
