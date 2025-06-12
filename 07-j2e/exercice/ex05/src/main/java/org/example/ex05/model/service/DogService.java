package org.example.ex05.model.service;

import jakarta.persistence.EntityNotFoundException;
import org.example.ex05.model.entity.Dog;
import org.example.ex05.model.repository.DogDAO;

import java.time.LocalDate;
import java.util.List;

public class DogService {

    private static DogDAO dogDAO;

    public DogService() {
        dogDAO = new DogDAO();
    }

    public Dog getById(int id) throws EntityNotFoundException { return dogDAO.get(id); }

    public List<Dog> getAll() {return dogDAO.get();}

    public Dog save(String name, String breed, LocalDate birthday) {
        Dog dog =  new Dog(name, breed, birthday);
        dogDAO.save(dog);
        return dog;
    }

    public Dog update(Dog dog) {
        try{
            dogDAO.get(dog.getId());
            return dogDAO.update(dog);
        } catch (EntityNotFoundException e){
            System.out.println("Ce chien n'existe pas");
            return null;
        }
    }

    public void delete(int id) { dogDAO.delete(id); }

}
