package com.bilgeadam.repository;

import com.bilgeadam.entity.Film;
import com.bilgeadam.entity.Odul;
import com.bilgeadam.entity.Oyuncu;
import com.bilgeadam.util.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class FilmDao implements ICrud<Film> {

    @Override
    public void save(Film film) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(film);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void update(Film film) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(film);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void findAll() {
        List<Object[]> list = new ArrayList<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String sql = "SELECT f.id,f.filmName,fk.name,y.fullName,od.odulAdi FROM film as f\n" +
                    "INNER JOIN Film_FilmKategori as ffk ON f.id = ffk.Film_id\n" +
                    "INNER JOIN FilmKategori as fk ON fk.id = ffk.filmKategori_id\n" +
                    "INNER JOIN film_yonetmen as fy ON f.id = fy.film_id\n" +
                    "INNER JOIN Yonetmen as y ON y.id = yonetmen_id\n" +
                    "INNER JOIN Film_Oyuncu as foy ON f.id = foy.Film_id\n" +
                    "INNER JOIN Oyuncu as oy ON oy.id = foy.oyuncu_id\n" +
                    "INNER JOIN Film_Odul as fod ON f.id = fod.Film_id\n" +
                    "INNER JOIN Odul as od ON od.id = fod.oduller_id";
            list = session.createNativeQuery(sql).getResultList();

            for (Object[] filmler : list) {
                System.out.println(
                        "Film ID: " + filmler[0]
                                + ", Film Adı: " + filmler[1]
                                + ", Film Kategorisi: " + filmler[2]
                                + ", Yönetmen Adı: " + filmler[3]
                                + ", Ödül Adı: " + filmler[4]
                );
            }

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteById(int id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Film film = null;
            session.beginTransaction();
            film = session.load(Film.class, id);
            session.delete(film);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}
