package com.example.ss5.repository.impl;

import com.example.ss5.model.Product;
import com.example.ss5.repository.ConnectionUtil;
import com.example.ss5.repository.IProductRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @Override
    public List<Product> getAll() {
        Session session = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            return session.createQuery("FROM Product ", Product.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public void save(Product product) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            session.save(product);
            transaction = session.beginTransaction();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void update(Product product) {
        Session session = null;
        Transaction transaction;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            product.setName(product.getName());
            product.setCost(product.getCost());
            session.update(product);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(int id) {
        Session session;
        Transaction transaction;
        try {
            Product product = findById(id);
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(product);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Product> searchByNameProduct(String nameProduct) {
        Session session = ConnectionUtil.sessionFactory.openSession();
        String query = "FROM Product where name like concat('%',:nameProduct,'%')";
        return session.createQuery(query, Product.class).setParameter("nameProduct", nameProduct).getResultList();
    }


    @Override
    public Product findById(int id) {
        Session session = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            String query = "FROM Product where id= :id";
            return session.createQuery(query, Product.class).setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return null;
    }
}


