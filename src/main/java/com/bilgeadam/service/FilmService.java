package com.bilgeadam.service;

import com.bilgeadam.entity.*;
import com.bilgeadam.repository.FilmDao;
import com.bilgeadam.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class FilmService {

    static FilmDao filmDao = new FilmDao();

    public static void main(String[] args) {
        //save();
        //update();
        //deleteById(4);
        //findAll();
    }

    public static void save() {
        try {
            Yonetmen yonetmen = new Yonetmen("James Cameron");
            Oyuncu oyuncu1 = new Oyuncu("Leonardo DiCaprio");
            Oyuncu oyuncu2 = new Oyuncu("Kate Winslet");
            Odul odul1 = new Odul("ödül1");
            Odul odul2 = new Odul("ödül2");
            FilmKategori filmKategori = new FilmKategori("Romantik");
            FilmKategori filmKategori2 = new FilmKategori("Korku");
            Film film = new Film("Ornek film", Arrays.asList(filmKategori, filmKategori2), Arrays.asList(odul1, odul2), Arrays.asList(oyuncu1, oyuncu2), yonetmen);
            filmDao.save(film);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update() {
        try {
            Yonetmen yonetmen = new Yonetmen("James Cameron");
            Oyuncu oyuncu1 = new Oyuncu("Leonardo DiCaprio");
            Oyuncu oyuncu2 = new Oyuncu("Kate Winslett");
            Odul odul1 = new Odul(1);
            FilmKategori filmKategori = new FilmKategori("Macera");
            Film film = new Film(1, "Titanik1", Arrays.asList(filmKategori), Arrays.asList(odul1), Arrays.asList(oyuncu1, oyuncu2), yonetmen);
            filmDao.update(film);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void findAll() {
        try {
            filmDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteById(int id) {
        try {
            filmDao.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
