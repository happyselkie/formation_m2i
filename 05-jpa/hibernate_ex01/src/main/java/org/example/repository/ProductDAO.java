package org.example.repository;

import org.example.entity.Product;
import org.example.util.SessionFactorySingleton;
import org.hibernate.SessionFactory;

import javax.persistence.TypedQuery;
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
            TypedQuery<Product> query = session.createQuery("select p from Product p where p.price <= :amount ", Product.class);
            query.setParameter("amount", amount);
            return query.getResultList();
        } catch (Exception ex){
            return new ArrayList<>();
        } finally {
            session.close();
        }
    }

    public List<Product> getFromToDates(String from, String to){
        try{
            session = sessionFactory.openSession();
            TypedQuery<Product> query = session.createQuery("select p from Product p where p.purchaseDate between :from AND :to" , Product.class);
            query.setParameter("from", from);
            query.setParameter("to", to);
            return query.getResultList();
        } catch (Exception ex){
            return new ArrayList<>();
        } finally {
            session.close();
        }
    }
}
