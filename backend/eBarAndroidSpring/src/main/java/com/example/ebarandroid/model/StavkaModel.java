package com.example.ebarandroid.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "stavka")
@Data
public class StavkaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stavka_id")
    private int id;

    @Column(name = "artikal_id")
    private int artikal_id;

    @Column(name = "kolicina")
    private float kolicina;

    @Column(name = "cena")
    private float cena;

    @Column(name = "order_id")
    private int order_id;

    @ManyToOne(cascade=CascadeType.ALL,optional=true, fetch=FetchType.EAGER)
    @JoinColumn(name = "artikal_id",insertable = false,updatable = false)
    private ArtikalModel artikal;



}
