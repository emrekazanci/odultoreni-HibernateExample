package com.bilgeadam.service;

import com.bilgeadam.entity.Film;
import com.bilgeadam.entity.Odul;
import com.bilgeadam.entity.Oyuncu;
import com.bilgeadam.repository.OyuncuDao;

import java.util.Arrays;

public class OyuncuService {

    static OyuncuDao oyuncuDao = new OyuncuDao();

    public static void main(String[] args) {
        //save();
        //update();
        //deleteById(7);
        //findAll();
        nameOfFilm("Java");
    }

    public static void save() {
        try {
            Film film1 = new Film("Java Boost");
            Odul odul1 = new Odul("En iyi Oyuncu ödülü");
            Oyuncu oyuncu = new Oyuncu("Ödül Alan Oyuncu2", Arrays.asList(film1), Arrays.asList(odul1));
            oyuncuDao.save(oyuncu);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update() {
        try {
            Film film1 = new Film(9, "Java11");
            Film film2 = new Film(10, "Java22");
            Odul odul1 = new Odul(8, "En iyi Öğrenci ödülü22");
            Odul odul2 = new Odul(9, "En iyi Erkek Öğrenci ödülü22");
            Oyuncu oyuncu = new Oyuncu(7, "Berke Kazancı", Arrays.asList(film1, film2), Arrays.asList(odul1, odul2));
            oyuncuDao.update(oyuncu);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void findAll() {
        try {
            oyuncuDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteById(int id) {
        try {
            oyuncuDao.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void nameOfFilm(String name) {
        try {
            oyuncuDao.nameOfFilm(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
