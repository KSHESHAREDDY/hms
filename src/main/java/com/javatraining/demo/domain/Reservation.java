package com.javatraining.demo.domain;

import com.javatraining.demo.common.ReservationStatus;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guest_id", referencedColumnName = "id")
    private Guest guest;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", referencedColumnName = "id")
    private Room room;

    private Date checkInDate;

    private Date checkOutDate;

    @Enumerated(EnumType.STRING)
    private ReservationStatus reservationStatus;


}
