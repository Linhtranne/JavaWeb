package com.data.repository;


import com.data.entity.Theater;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TheaterRepositoryImp implements TheaterRepository {

    private final SessionFactory sessionFactory;

    public TheaterRepositoryImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public List<Theater> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Theater", Theater.class).list();
        }
    }
    @Override
    public Theater findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Theater.class, id);
        }
    }
    @Override
    public void save(Theater theater) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(theater);
            session.getTransaction().commit();
        }
    }
    @Override
    public void delete(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Theater theater = session.get(Theater.class, id);
            if (theater != null) {
                session.delete(theater);
            }
            session.getTransaction().commit();
        }
    }
}