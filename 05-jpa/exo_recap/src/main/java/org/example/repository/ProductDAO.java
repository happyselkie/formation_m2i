package org.example.repository;

import org.example.entity.Product;
import org.example.entity.ProductClothe;
import org.example.entity.ProductElectronic;
import org.example.entity.ProductFood;
import org.example.util.SessionFactorySingleton;

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
            List<Product> products = session.createQuery("select p from Product p", Product.class).getResultList();
            return products;
        }catch (Exception ex){
            return new ArrayList<>();
        }finally {
            session.close();
        }
    }

    public List<ProductFood> getFoods(){
        try{
            session = sessionFactory.openSession();
            List<ProductFood> products = session.createQuery("select p from ProductFood p", ProductFood.class).getResultList();
            return products;
        }catch (Exception ex){
            return new ArrayList<>();
        } finally {
            session.close();
        }
    }

    public List<ProductElectronic> getElectronics(){
        try{
            session = sessionFactory.openSession();
            List<ProductElectronic> products = session.createQuery("select p from ProductElectronic p", ProductElectronic.class).getResultList();
            return products;
        }catch (Exception ex){
            return new ArrayList<>();
        } finally {
            session.close();
        }
    }

    public List<ProductClothe> getClothes(){
        try{
            session = sessionFactory.openSession();
            List<ProductClothe> products = session.createQuery("select p from ProductClothe p", ProductClothe.class).getResultList();
            return products;
        }catch (Exception ex){
            return new ArrayList<>();
        } finally {
            session.close();
        }
    }

    public List<Product> getUnderStockAmount(int stockAmount){
        try{
            session = sessionFactory.openSession();
            List<Product> products = session.createQuery("select p.stock from Product p where p.stock < :stockAmount", Product.class).getResultList();
            return products;
        }catch (Exception ex){
            return new ArrayList<>();
        }finally {
            session.close();
        }
    }

}
