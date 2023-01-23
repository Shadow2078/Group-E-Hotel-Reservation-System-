package com.system.hotel_reservation_system.entity;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="review")
public class Review {
    @Id
    @SequenceGenerator(name = "hrs_room_seq_gen", sequenceName = "pms_room_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "hrs_room_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private Integer location;

    @Column(nullable = false)
    private Integer pricing;

    @Column(nullable = false)
    private Integer comfort;

    @Column(nullable = false)
    private Integer service;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String description;
}
