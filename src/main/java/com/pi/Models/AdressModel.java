package com.pi.Models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class AdressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "adress_id",nullable = false)
    private UUID adressId;
    @Column(name = "postal_code",nullable = false)
    private String postalCode;
    @Column(name = "complement",nullable = false)
    private String complement;
    @Column(name = "country",nullable = false)
    private String country;
    @Column(name = "state",nullable = false)
    private String state;
}
