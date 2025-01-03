package net.happiness.observer;

import net.happiness.observable.Subject;

import java.util.Objects;

public class EmailTopicSubscriber implements Observer {

    private final String name;

    private Subject topic;

    public EmailTopicSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void subscribe(Subject subject) {
        topic = subject;
    }

    @Override
    public void update() {
        String message = (String) topic.getUpdate();
        if (Objects.nonNull(message)) {
            System.out.println(name + " has retrieved the message: " + message);
        } else {
            System.out.println("Topic does not have a message.");
        }
    }

}
