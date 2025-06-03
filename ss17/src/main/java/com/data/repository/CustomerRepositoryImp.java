package com.data.repository;

import com.data.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;
import java.util.List;

@Repository
public class CustomerRepositoryImp implements CustomerRepository {
    private final SessionFactory sessionFactory;

    public CustomerRepositoryImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Customer customer) {
        Session session = sessionFactory.openSession();;
        session.save(customer);
    }

    public List<Customer> getAll() {
        Session session = sessionFactory.openSession();
        try {
            Query<Customer> query = session.createQuery("FROM Customer", Customer.class);
            List<Customer> customers = query.getResultList();
            return customers;
        } finally {
            session.close();
        }
    }
    @Override
    public Customer findByUsernameAndPassword(String username, String password) {
        Session session = sessionFactory.openSession();
        try {
            Query<Customer> query = session.createQuery("FROM Customer WHERE username = :username AND password = :password", Customer.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
            return query.uniqueResult();
        } finally {
            session.close();
        }
    }

    @Override
    public Customer findById(int id) {
        Session session = sessionFactory.openSession();
        try {
            return session.get(Customer.class, id);
        } finally {
            session.close();
        }
    }
}
