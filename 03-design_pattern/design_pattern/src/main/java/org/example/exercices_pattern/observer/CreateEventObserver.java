package org.example.exercices_pattern.observer;

public class CreateEventObserver implements Observer {

    private String name;

    public CreateEventObserver(String name) {
        this.name = name;
    }

    @Override
    public void notify(String message) {
        System.out.println(name + ", un évènement a été créé: " + message);
    }
}
