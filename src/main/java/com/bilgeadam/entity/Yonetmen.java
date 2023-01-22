package com.bilgeadam.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Yonetmen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Film> film;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "yonetmen_odul",
            joinColumns = @JoinColumn(name = "yonetmen_id"),inverseJoinColumns = @JoinColumn(name = "odul_id"))
    private Odul odul;

    public Yonetmen(Integer id) {
        this.id = id;
    }

    public Yonetmen(String fullName) {
        this.fullName = fullName;
    }

    public Yonetmen(String fullName, List<Film> film, Odul odul) {
        this.fullName = fullName;
        this.film = film;
        this.odul = odul;
    }

    public Yonetmen(Integer id, String fullName, List<Film> film, Odul odul) {
        this.id = id;
        this.fullName = fullName;
        this.film = film;
        this.odul = odul;
    }
}
