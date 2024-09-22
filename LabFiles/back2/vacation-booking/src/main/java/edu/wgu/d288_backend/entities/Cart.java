package edu.wgu.d288_backend.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
// import javax.persistence.*;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "carts")
@Data
@Getter
@Setter
@ToString
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long cartId;

    @Column(name = "package_price")
    private Integer packagePrice;

    @Column(name = "party_size")
    private Integer partySize;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private StatusType status;

    @Column(name = "order_tracking_number")
    private String orderTrackingNumber;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "last_update")
    private Date lastUpdate;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
}
