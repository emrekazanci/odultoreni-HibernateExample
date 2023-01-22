package com.bilgeadam.repository;

import com.bilgeadam.entity.Yonetmen;
import com.bilgeadam.util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class YonetmenDao implements ICrud<Yonetmen> {

    @Override
    public void save(Yonetmen yonetmen) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(yonetmen);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void update(Yonetmen yonetmen) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(yonetmen);
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
            String sql = "SELECT y.id,y.fullName,f.filmName,o.odulAdi FROM yonetmen as y \n" +
                    "INNER JOIN yonetmen_film as yf ON yf.Yonetmen_id = y.id\n" +
                    "INNER JOIN Film as f ON yf.film_id = f.id\n" +
                    "INNER JOIN yonetmen_odul as yo ON yo.yonetmen_id = y.id\n" +
                    "INNER JOIN odul as o ON yo.odul_id = o.id";
            list = session.createNativeQuery(sql).getResultList();
            for (Object[] item : list) {
                System.out.println(
                        "Yönetmen ID: " + item[0]
                                + ", Yönetmen Adı: " + item[1]
                                + ", Film Adı: " + item[2]
                                + ", Ödül Adı: " + item[3]
                );
            }
        } catch (Exception e) {

        }
    }

    @Override
    public void deleteById(int id) {
        Yonetmen yonetmen;
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            yonetmen = session.load(Yonetmen.class, id);
            session.delete(yonetmen);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
