package org.example.exercices_pattern.observer;

public class DeleteObserver implements Observer{

    private String name;

    public DeleteObserver(String name) {
        this.name = name;
    }

    @Override
    public void notify(String message) {
        System.out.println(name + ", un évènement a été supprimé: " + message);
    }
}
