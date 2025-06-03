package org.example.repository;

import org.example.entity.Product;
import org.example.util.SessionFactorySingleton;
import org.hibernate.SessionFactory;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends BaseDAO<Product> {

    public ProductDAO() {
        super(SessionFactorySingleton.getSessionFactory(), Product.class);
    }

    @Override
    public List<Product> get() {
        try{
            session = sessionFactory.openSession();
            return session.createQuery("select p from Product p", Product.class).getResultList();
        }catch (Exception ex){
            return new ArrayList<>();
        }finally {
            session.close();
        }
    }

    public List<Product> getByPriceUnderAmount(int amount){
        try{
            session = sessionFactory.openSession();
            return session.createQuery("select p from Product p where p.price <= " + amount, Product.class).getResultList();
        } catch (Exception ex){
            return new ArrayList<>();
        } finally {
            session.close();
        }
    }

    public List<Product> getFromToDates(Date from, Date to){
        try{
            session = sessionFactory.openSession();
            return session.createQuery("select p from Product p where p.purchaseDate >= " + from + " AND p.purchaseDate < " +to , Product.class).getResultList();
        } catch (Exception ex){
            return new ArrayList<>();
        } finally {
            session.close();
        }
    }
}
