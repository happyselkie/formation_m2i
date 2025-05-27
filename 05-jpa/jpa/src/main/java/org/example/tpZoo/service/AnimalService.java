package org.example.tpZoo.service;

import org.example.demoJPA.entity.Account;
import org.example.tpZoo.entity.Animal;
import org.example.tpZoo.utils.Diet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class AnimalService {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo");
    private EntityManager em = emf.createEntityManager();


    public Animal createAnimal(String name, int age, String diet, String date){
        java.util.Date arrival_date = new java.util.Date();
        DateFormat df = new SimpleDateFormat("dd-MM-yy");

        try{
            arrival_date = df.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        java.sql.Date sqlDate = new java.sql.Date(arrival_date.getTime());

        Animal animal = Animal.builder().name(name).age(age).diet(Diet.valueOf(diet.toUpperCase())).arrivalDate(sqlDate).build();

        em.getTransaction().begin();
        em.persist(animal);
        em.getTransaction().commit();

        System.out.println(animal + " created");
        return animal;
    }

    public void editAnimal(Animal animal){

        try{
            Animal editAnimal = em.find(Animal.class, animal.getId());
            em.getTransaction().begin();
            editAnimal.setName(animal.getName());
            editAnimal.setAge(animal.getAge());
            editAnimal.setDiet(animal.getDiet());
            editAnimal.setArrivalDate(animal.getArrivalDate());
            em.getTransaction().commit();
        } catch (EntityNotFoundException e){
            System.out.println(e.getMessage());
        }
    }

}
