package com.data.repository;

import com.data.entity.ScreenRoom;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScreenRoomRepositoryImp implements ScreenRoomRepository  {

    private final SessionFactory sessionFactory;

    public ScreenRoomRepositoryImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public List<ScreenRoom> findAllActive() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM ScreenRoom WHERE status = true", ScreenRoom.class).list();
        }
    }
    @Override
    public ScreenRoom findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(ScreenRoom.class, id);
        }
    }
    @Override
    public void save(ScreenRoom screenRoom) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.saveOrUpdate(screenRoom);
            session.getTransaction().commit();
        }
    }
    @Override
    public void delete(ScreenRoom screenRoom) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            screenRoom.setStatus(false);
            session.update(screenRoom);
            session.getTransaction().commit();
        }
    }
}