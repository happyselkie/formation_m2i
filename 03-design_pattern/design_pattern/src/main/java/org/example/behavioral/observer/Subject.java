package org.example.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer){
        observers.add(observer);
    }

    public void removeOberserver(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(String message){
        for (Observer observer : observers){
            observer.update(message);
        }
    }

}
