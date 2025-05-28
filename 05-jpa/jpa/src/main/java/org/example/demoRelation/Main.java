package org.example.demoRelation;

import org.example.demoRelation.OneToOne.Coordonnees;
import org.example.demoRelation.OneToOne.Etudiant;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_demo");
        EntityManager em = emf.createEntityManager();

        Coordonnees coordonnees = Coordonnees.builder().adresse("12 rue des lilas").codePostal(59000).build();
        Etudiant etudiant = Etudiant.builder().name("toto").age(20).coordonnees(coordonnees).build();

/*        em.getTransaction().begin();
        em.persist(coordonnees);
        em.persist(etudiant);
        em.getTransaction().commit();*/


        // Demo ONE TO ONE
        System.out.println(em.find(Etudiant.class, 1));
        System.out.println(em.find(Coordonnees.class, 1).getEtudiant());



    }
}
