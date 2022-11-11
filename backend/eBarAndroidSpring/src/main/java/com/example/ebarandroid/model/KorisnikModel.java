package com.example.ebarandroid.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "korisnik")
@Data
public class KorisnikModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "korisnik_id")
    private int id;

    @Column(name = "ime")
    private String ime;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
}
