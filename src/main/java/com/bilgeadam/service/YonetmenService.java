package com.bilgeadam.service;

import com.bilgeadam.entity.Film;
import com.bilgeadam.entity.Odul;
import com.bilgeadam.entity.Yonetmen;
import com.bilgeadam.repository.YonetmenDao;

import java.util.Arrays;

public class YonetmenService {

    static YonetmenDao yonetmenDao = new YonetmenDao();

    public static void main(String[] args) {
        //save();
        //update();
        //deleteById(5);
        findAll();
    }

    public static void save() {
        try {
            Odul odul = new Odul("En iyi hoca ödülü2");
            Film film = new Film("Java Boost 777-güz");
            Film film2 = new Film("Java 77");
            Yonetmen yonetmen = new Yonetmen("Arda Ağdemir", Arrays.asList(film, film2), odul);
            yonetmenDao.save(yonetmen);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update() {
        try {
            Odul odul = new Odul(7, "En iyi hoca ödülü22");
            Film film = new Film(7, "Java Boost 888-güz");
            Film film2 = new Film(8, "Java 88");
            Yonetmen yonetmen = new Yonetmen(5, "Arda Ağdemir", Arrays.asList(film, film2), odul);
            yonetmenDao.update(yonetmen);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void findAll() {
        try {
            yonetmenDao.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteById(int id) {
        try {
            yonetmenDao.deleteById(id);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
