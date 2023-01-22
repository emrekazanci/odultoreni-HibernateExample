package com.bilgeadam.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Oyuncu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullName;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Film> film;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Odul> oduller;

    public Oyuncu(Integer id) {
        this.id = id;
    }

    public Oyuncu(String fullName) {
        this.fullName = fullName;
    }

    public Oyuncu(String fullName, List<Film> film, List<Odul> oduller) {
        this.fullName = fullName;
        this.film = film;
        this.oduller = oduller;
    }

    public Oyuncu(Integer id, String fullName, List<Film> film, List<Odul> oduller) {
        this.id = id;
        this.fullName = fullName;
        this.film = film;
        this.oduller = oduller;
    }
}
