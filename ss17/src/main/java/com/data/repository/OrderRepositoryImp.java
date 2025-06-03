package com.data.repository;

import com.data.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;
import java.util.List;

@Repository
public class OrderRepositoryImp implements OrderRepository {
    private final SessionFactory sessionFactory;

    public OrderRepositoryImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Order order) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(order);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Order> findByCustomerId(int customerId, int page, int size) {
        Session session = sessionFactory.openSession();
        try {
            Query<Order> query = session.createQuery("FROM Order WHERE customerId = :customerId", Order.class);
            query.setParameter("customerId", customerId);
            query.setFirstResult(page * size);
            query.setMaxResults(size);
            return query.getResultList();
        } finally {
            session.close();
        }
    }

    @Override
    public Order findById(int id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Order.class, id);
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(Order order) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.delete(order);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    @Override
    public int countByCustomerId(int customerId) {
        Session session = sessionFactory.openSession();
        try {
            Query<Long> query = session.createQuery("SELECT COUNT(*) FROM Order WHERE customerId = :customerId", Long.class);
            query.setParameter("customerId", customerId);
            return query.uniqueResult().intValue();
        } finally {
            session.close();
        }
    }
}