package org.example.tp_parc.dao;

import org.example.tp_parc.entity.Computer;
import org.example.tp_parc.entity.Identification;
import org.example.tp_parc.utils.DatabaseManager;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ComputerDao {
    private EntityManager em;

    public ComputerDao() {
        em = DatabaseManager.getEntityManager();
    }

    public Computer createComputer (Computer computer){
        em.getTransaction().begin();
        em.persist(computer);
        em.getTransaction().commit();
        return computer;
    }

    public Computer getById (int id){
        return em.find(Computer.class,id);
    }

    public Computer getComputerByIdentification (Identification identification){
        TypedQuery<Computer> query = em.createQuery("select c from Computer c where c.identification = :identification", Computer.class);
        query.setParameter("identification",identification);
        return query.getSingleResult();
    }

    public List<Computer> getComputersByModel (String model){
        TypedQuery<Computer> query = em.createQuery("select c from Computer c where c.model = :model", Computer.class);
        query.setParameter("model",model);
        return query.getResultList();
    }

    public void updateComputer (Computer computer){
        em.getTransaction().begin();
        em.merge(computer);
        em.getTransaction().commit();
    }

    public void deleteComputer (Computer computer){
        em.getTransaction().begin();
        em.remove(computer);
        em.getTransaction().commit();
    }
}
