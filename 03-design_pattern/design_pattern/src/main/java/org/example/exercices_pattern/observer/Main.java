package org.example.exercices_pattern.observer;

public class Main {
    public static void main(String[] args) {
        EventManager eventManager = new EventManager();

        Observer createObserver = new CreateEventObserver("createObserver");
        Observer observerSave = new ObserverSave("observerSave");

        eventManager.addObserver(createObserver);
        eventManager.addObserver(observerSave);

        eventManager.notifyObservers("Event 01");
        eventManager.notifyObservers("Event 02");
    }
}
