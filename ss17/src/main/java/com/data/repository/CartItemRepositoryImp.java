package com.data.repository;

import com.data.entity.CartItem;
import com.data.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;
import java.util.List;

@Repository
public class CartItemRepositoryImp implements CartItemRepository {
    private final SessionFactory sessionFactory;

    public CartItemRepositoryImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(CartItem cartItem) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(cartItem);
    }

    @Override
    public List<CartItem> findByCustomer(Customer customer) {
        Session session = sessionFactory.openSession();
        try {
            Query<CartItem> query = session.createQuery("FROM CartItem WHERE customer = :customer", CartItem.class);
            query.setParameter("customer", customer);
            return query.getResultList();
        } finally {
            session.close();
        }
    }

    @Override
    public void delete(CartItem cartItem) {
        Session session = sessionFactory.openSession();
        session.delete(cartItem);
    }
}
