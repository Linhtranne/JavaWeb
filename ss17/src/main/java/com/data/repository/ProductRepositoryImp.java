package com.data.repository;

import com.data.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;
import java.util.List;

@Repository
public class ProductRepositoryImp implements ProductRepository {
    private final SessionFactory sessionFactory;

    public ProductRepositoryImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Product product) {
        Session session = sessionFactory.openSession();
        session.save(product);
    }

    @Override
    public List<Product> findAllWithPagination(int start, int limit) {
        Session session = sessionFactory.openSession();
        try {
            Query<Product> query = session.createQuery("FROM Product", Product.class);
            query.setFirstResult(start);
            query.setMaxResults(limit);
            return query.getResultList();
        } finally {
            session.close();
        }
    }

    @Override
    public long getTotalProducts() {
        Session session = sessionFactory.openSession();
        try {
            Query<Long> query = session.createQuery("SELECT COUNT(*) FROM Product", Long.class);
            return query.uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public Product findById(int id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Product.class, id);
        } finally {
            session.close();
        }
    }
}