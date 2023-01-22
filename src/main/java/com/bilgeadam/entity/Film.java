package com.bilgeadam.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String filmName;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<FilmKategori> filmKategori;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Odul> oduller;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Oyuncu> oyuncu;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "film_yonetmen",
    joinColumns = @JoinColumn(name = "film_id"),inverseJoinColumns = @JoinColumn(name = "yonetmen_id"))
    private Yonetmen yonetmen;

    public Film(Integer id) {
        this.id = id;
    }

    public Film(String filmName) {
        this.filmName = filmName;
    }

    public Film(Integer id, String filmName) {
        this.id = id;
        this.filmName = filmName;
    }

    public Film(String filmName, List<Odul> oduller, List<Oyuncu> oyuncu, Yonetmen yonetmen) {
        this.filmName = filmName;
        this.oduller = oduller;
        this.oyuncu = oyuncu;
        this.yonetmen = yonetmen;
    }

    public Film(String filmName, List<FilmKategori> filmKategori, List<Odul> oduller, List<Oyuncu> oyuncu, Yonetmen yonetmen) {
        this.filmName = filmName;
        this.filmKategori = filmKategori;
        this.oduller = oduller;
        this.oyuncu = oyuncu;
        this.yonetmen = yonetmen;
    }

    public Film(Integer id, String filmName, List<FilmKategori> filmKategori, List<Odul> oduller, List<Oyuncu> oyuncu, Yonetmen yonetmen) {
        this.id = id;
        this.filmName = filmName;
        this.filmKategori = filmKategori;
        this.oduller = oduller;
        this.oyuncu = oyuncu;
        this.yonetmen = yonetmen;
    }
}
