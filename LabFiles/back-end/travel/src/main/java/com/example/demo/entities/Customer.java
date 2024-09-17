// package com.example.demo.entities;

// import lombok.Data;
// import javax.persistence.*;
// import java.util.List;

// @Entity
// @Data
// public class Customer {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String firstName;
//     private String lastName;
//     private String email;

//     @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//     private List<VacationPackage> vacationPackages;
// }

package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="customer")
@Getter
@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;
}
