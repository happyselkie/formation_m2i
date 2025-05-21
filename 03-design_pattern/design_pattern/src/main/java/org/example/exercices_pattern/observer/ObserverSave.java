package org.example.exercices_pattern.observer;

public class ObserverSave implements Observer{
    private String name;

    public ObserverSave(String name) {
        this.name = name;
    }

    @Override
    public void notify(String message) {
        System.out.println(name + ", a enregistré dans un fichier: " + message);
    }
}
