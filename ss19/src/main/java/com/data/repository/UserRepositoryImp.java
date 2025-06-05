package com.data.repository;

import com.data.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImp implements UserRepository {

    private final SessionFactory sessionFactory;

    public UserRepositoryImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public List<User> findAll(int page, int size) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM User", User.class)
                    .setFirstResult((page - 1) * size)
                    .setMaxResults(size)
                    .list();
        }
    }
@Override
public void updateUserStatus(Long userId, boolean isActive) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            User user = session.get(User.class, userId);
            if (user != null) {
                user.setIsActive(isActive);
                session.update(user);
            }
            session.getTransaction().commit();
        }
    }
    @Override
    public long countUsers() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("SELECT COUNT(u) FROM User u", Long.class).getSingleResult();
        }
    }
}