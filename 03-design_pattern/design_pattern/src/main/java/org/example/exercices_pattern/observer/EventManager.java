package org.example.exercices_pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class EventManager {

    private List<Observer> createObservers = new ArrayList<>();
    private List<Observer> deleteObservers = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();


    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void addCreateObservers(Observer observer){
        createObservers.add(observer);
    }

    public void addDeleteObservers(Observer observer){
        deleteObservers.add(observer);
    }

    public void notifyObservers(String message){
        for (Observer observer : observers){
            observer.notify(message);
        }
    }

    public void notifyCreateObservers(String message){
        for (Observer observer : createObservers){
            observer.notify(message);
        }
    }
    public void notifyDeleteObservers(String message){
        for (Observer observer : deleteObservers){
            observer.notify(message);
        }
    }

    public Event newEvent(String name){
        this.notifyCreateObservers(name);
        this.notifyObservers(name);
        return new Event(name);
    }
    public void delEvent(Event event){
        this.notifyDeleteObservers(event.getName());
        this.notifyObservers(event.getName());
    }
}
