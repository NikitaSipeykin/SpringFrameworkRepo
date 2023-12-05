package com.gb.spring.lessons.GB_Spring.repository;

import com.gb.spring.lessons.GB_Spring.dto.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDao {


    public Product findById(long id) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        Product product;

        try (Session session = sessionFactory.getCurrentSession()) {
            session.getTransaction().begin();

            product = session.find(Product.class, 1L);

            session.getTransaction().commit();
        }
        sessionFactory.close();
        return product;
    }


    public List<Product> findAll() {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        List products = new ArrayList<>();

        EntityManager entityManager = sessionFactory.createEntityManager();
        entityManager.getTransaction().begin();

        products = entityManager
                .createQuery("from Product s", Product.class)
                .getResultList();

        return products;
    }


    public void deleteById(long id) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.getTransaction().begin();

            Product product = session.get(Product.class, id);
            session.delete(product);

            session.getTransaction().commit();
        }
        sessionFactory.close();
    }


    public Product saveOrUpdate(Product product) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        try (Session session = sessionFactory.getCurrentSession()) {
            session.getTransaction().begin();

            session.save(product);

            session.getTransaction().commit();
        }
        sessionFactory.close();
        return product;
    }
}
