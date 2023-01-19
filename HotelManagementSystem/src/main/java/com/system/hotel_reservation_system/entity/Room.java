package com.system.hotel_reservation_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="rooms")
public class Room{
    @Id
    @SequenceGenerator(name = "hrs_room_seq_gen", sequenceName = "pms_room_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "hrs_room_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String hotelname;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String room_description;

    @Column(nullable = false)
    private String room_type;

    @Column(nullable = false)
    private String phone_number;

    @Column(nullable = false)
    private Integer no_of_people;

    @Column(nullable = false)
    private String beds;
    


    private String image1;

    private String image2;

    private String image3;

    private String image4;

    private String image5;
}