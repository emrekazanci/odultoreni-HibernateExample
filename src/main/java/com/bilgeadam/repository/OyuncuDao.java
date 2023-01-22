package com.bilgeadam.repository;

import com.bilgeadam.entity.Oyuncu;
import com.bilgeadam.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class OyuncuDao implements ICrud<Oyuncu> {

    @Override
    public void save(Oyuncu oyuncu) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(oyuncu);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void update(Oyuncu oyuncu) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(oyuncu);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void findAll() {
        List<Object[]> list;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String sql = "SELECT o.id,o.fullName,f.filmName,od.odulAdi FROM oyuncu as o\n" +
                    "INNER JOIN oyuncu_film as oyf ON oyf.oyuncu_id = o.id\n" +
                    "INNER JOIN film as f ON oyf.film_id = f.id\n" +
                    "INNER JOIN oyuncu_odul as oo ON oo.oyuncu_id = o.id\n" +
                    "INNER JOIN odul as od ON oo.oduller_id = od.id";
            list = session.createNativeQuery(sql).getResultList();
            for (Object[] item : list) {
                System.out.println(
                        "Oyuncu ID: " + item[0]
                                + ", Oyuncu Adı: " + item[1]
                                + ", Film Adı: " + item[2]
                                + ", Ödül Adı: " + item[3]
                );
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {
        Oyuncu oyuncu = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            oyuncu = session.load(Oyuncu.class, id);
            session.delete(oyuncu);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    public void nameOfFilm(String name) {
        List<Object[]> list = null;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            String sql = "SELECT f.id as 'film id',f.filmName,o.id,o.fullName,od.odulAdi FROM oyuncu as o\n" +
                    "INNER JOIN oyuncu_film as oyf ON oyf.oyuncu_id = o.id\n" +
                    "INNER JOIN film as f ON oyf.film_id = f.id\n" +
                    "INNER JOIN oyuncu_odul as oo ON oo.oyuncu_id = o.id\n" +
                    "INNER JOIN odul as od ON oo.oduller_id = od.id\n" +
                    "WHERE f.filmName = ?";
            Query query = session.createNativeQuery(sql).setParameter(1, name);
            list = query.getResultList();
            for (Object[] item : list) {
                System.out.println(
                        "Oyuncu ID: " + item[0]
                                + ", Oyuncu Adı: " + item[1]
                                + ", Film ID: " + item[2]
                                + ", Film Adı: " + item[3]
                                + ", Ödül Adı: " + item[4]
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
