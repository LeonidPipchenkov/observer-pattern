package net.happiness;

import net.happiness.observable.EmailTopic;
import net.happiness.observer.EmailTopicSubscriber;
import net.happiness.observer.Observer;

public class Main {

    public static void main(String[] args) {
        EmailTopic topic = new EmailTopic();

        Observer firstObserver = new EmailTopicSubscriber("First Observer");
        Observer secondObserver = new EmailTopicSubscriber("Second Observer");
        Observer thirdObserver = new EmailTopicSubscriber("Third Observer");

        topic.register(firstObserver);
        topic.register(secondObserver);
        topic.register(thirdObserver);

        firstObserver.subscribe(topic);
        secondObserver.subscribe(topic);
        thirdObserver.subscribe(topic);

        firstObserver.update();
        thirdObserver.update();

        topic.postMessage("Hello Subscribers!");

        topic.unregister(firstObserver);

        topic.postMessage("Hello Subscribers again!");
    }

}
