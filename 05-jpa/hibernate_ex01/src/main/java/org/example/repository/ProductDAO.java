package org.example.repository;

import org.example.entity.Product;
import org.hibernate.Session;

import java.util.List;

public class ProductDAO {

   private Session session;

    public ProductDAO(Session session) {
        this.session = session;
    }

    public Product findById(int id) {
        return session.get(Product.class, id);
    }

    public List<Product> findAll() {
        return session.createQuery("select p from Product p", Product.class).list();
        //return session.createCriteria(Person.class).list();
    }

    public Product save(Product product) {
        session.beginTransaction();
        session.saveOrUpdate(product);
        session.getTransaction().commit();

        return product;
    }

    public boolean delete(Product product) {
        session.beginTransaction();
        session.delete(product);
        session.getTransaction().commit();
        return true;
    }

}
