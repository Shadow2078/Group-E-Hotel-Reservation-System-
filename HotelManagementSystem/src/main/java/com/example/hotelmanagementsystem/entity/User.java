package com.example.hotelmanagementsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    @Id
    @SequenceGenerator(name = "tms_user_seq_gen", sequenceName = "tms_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "tms_user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String email;

    @Column(name = "mobileNo")
    private String mobileNo;
}