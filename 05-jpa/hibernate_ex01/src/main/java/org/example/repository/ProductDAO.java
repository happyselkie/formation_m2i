package org.example.repository;

import org.example.entity.Product;
import org.example.util.SessionFactorySingleton;

import javax.persistence.TypedQuery;
import java.time.LocalDate;
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

    public List<Product> getFromToDates(LocalDate from, LocalDate to){
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

    public List<Product> getRefUnderStock(int stock){
        try{
            session = sessionFactory.openSession();
            TypedQuery<Product> query = session.createQuery("select p.ref from Product p where p.stock < :stock", Product.class);
            query.setParameter("stock", stock);
            return query.getResultList();
        } catch (Exception ex){
            return new ArrayList<>();
        } finally {
            session.close();
        }
    }

    public long getStockByBrand(String brand){
        try {
            session = sessionFactory.openSession();
            TypedQuery<Long> query = session.createQuery("select sum(p.stock) from Product p where p.brand = :brand", Long.class);
            query.setParameter("brand", brand);
            return query.getSingleResult();
        } catch (Exception ex){
            return 0;
        } finally {
            session.close();
        }
    }

    public double getAvgPrice(){
        try{
            session = sessionFactory.openSession();
            TypedQuery<Double> query = session.createQuery("select avg(p.price) from Product p", Double.class);
            return query.getSingleResult();
        } catch (Exception ex){
            return 0;
        } finally {
            session.close();
        }
    }

    public List<Product> getByBrand(String brand){
        try{
            session = sessionFactory.openSession();
            TypedQuery<Product> query = session.createQuery("select p from Product p where p.brand = :brand", Product.class);
            query.setParameter("brand", brand);
            return query.getResultList();
        } catch (Exception ex){
            return new ArrayList<>();
        } finally {
            session.close();
        }
    }

    public void deleteByBrand(String brand){
        try{
            session = sessionFactory.openSession();
            TypedQuery<Product> query = session.createQuery("delete from Product p where p.brand = :brand", Product.class);
            query.setParameter("brand", brand);
            query.executeUpdate();
        } catch (Exception ex){
            return;
        }
        finally {
            session.close();
        }
    }


}
