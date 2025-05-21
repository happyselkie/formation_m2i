package org.example.exercices_pattern.observer;

public class Main {
    public static void main(String[] args) {
        EventManager eventManager = new EventManager();

        Observer observerSave = new ObserverSave("observerSave");
        Observer createObserver = new CreateEventObserver("createObserver");
        Observer deleteObserver = new DeleteObserver("deleteObserver");

        eventManager.addObserver(observerSave);
        eventManager.addCreateObservers(createObserver);
        eventManager.addDeleteObservers(deleteObserver);

        Event event1 = eventManager.newEvent("Event 01");
        Event event2 = eventManager.newEvent("Event 02");
        eventManager.delEvent(event1);
    }
}
