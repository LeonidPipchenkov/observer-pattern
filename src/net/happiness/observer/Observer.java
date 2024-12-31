package net.happiness.observer;

import net.happiness.observable.Subject;

public interface Observer {
    void subscribe(Subject subject);
    void update();
}
