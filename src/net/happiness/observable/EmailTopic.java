package net.happiness.observable;

import net.happiness.observer.Observer;

import java.util.List;
import java.util.Objects;

public class EmailTopic implements Subject {

    private final List<Observer> observers;
    private String message;

    public EmailTopic(List<Observer> observers) {
        this.observers = observers;
    }

    @Override
    public void register(Observer observer) {
        if (Objects.nonNull(observer)) {
            if (!observers.contains(observer)) {
                observers.add(observer);
            }
        } else {
            throw new NullPointerException("Given observer is null");
        }
    }

    @Override
    public void unregister(Observer observer) {
        if (Objects.nonNull(observer)) {
            observers.remove(observer);
        } else {
            throw new NullPointerException("Given observer is null");
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public Object getUpdate(Observer observer) {
        return message;
    }

    public void postMessage(String message) {
        System.out.println("Message posted to topic: " + message);
        this.message = message;
        notifyObservers();
    }

}
