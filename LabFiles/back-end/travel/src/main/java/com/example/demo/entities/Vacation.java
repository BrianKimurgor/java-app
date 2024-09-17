// package com.example.demo.entities;

// import lombok.Data;
// import javax.persistence.*;
// import java.math.BigDecimal;

// @Entity
// @Data
// public class VacationPackage {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String packageName;
//     private BigDecimal price;

//     @ManyToOne
//     @JoinColumn(name = "customer_id")
//     private Customer customer;
// }

package com.example.demo.entities;

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
