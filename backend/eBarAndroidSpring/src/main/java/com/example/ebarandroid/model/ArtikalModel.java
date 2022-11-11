package com.example.ebarandroid.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "artikal")
@Data
public class ArtikalModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artikal_id")
    private int id;

    @Column(name = "naziv")
    private String naziv;

    @Column(name = "cena")
    private float cena;

    @Column(name = "kategorija_id")
    private int kategorija_id;

}
