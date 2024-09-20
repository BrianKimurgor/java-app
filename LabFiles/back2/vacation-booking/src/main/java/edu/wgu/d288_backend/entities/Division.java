package edu.wgu.d288_backend.entities;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "divisions")
@Data
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "division_id")
    private Long divisionId;

    @Column(name = "division")
    private String division;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "last_update")
    private Date lastUpdate;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;
}
