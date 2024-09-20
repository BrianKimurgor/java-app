package edu.wgu.d288_backend.entities;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vacations")
@Data
public class Vacation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    private Long vacationId;

    @Column(name = "vacation_title")
    private String vacationTitle;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "travel_fare_price")
    private Double travelFarePrice;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "last_update")
    private Date lastUpdate;
}
