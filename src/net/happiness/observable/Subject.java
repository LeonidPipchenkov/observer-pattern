package net.happiness.observable;

import net.happiness.observer.Observer;

public interface Subject {
    void register(Observer observer);
    void unregister(Observer observer);
    void notifyObservers();
    Object getUpdate();
}
