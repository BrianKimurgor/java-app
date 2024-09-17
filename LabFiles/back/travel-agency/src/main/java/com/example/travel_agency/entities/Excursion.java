package main.java.com.example.travel_agency.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name="excursion")
@Getter
@Setter
public class Excursion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="excursion_title")
    private String excursionTitle;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name="vacation_id", nullable=false)
    private Vacation vacation;
}
