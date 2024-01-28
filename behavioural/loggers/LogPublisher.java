package behavioural.loggers;

import java.util.ArrayList;
import java.util.List;

public class LogPublisher implements Publisher{

    private final List<Subscriber> subscriberList;

    public LogPublisher() {
        this.subscriberList = new ArrayList<>();
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        subscriberList.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
      subscriberList.remove(subscriber);
    }

    @Override
    public void notify(String message) {
       for(Subscriber subscriber:subscriberList){
           subscriber.publish(message);
       }
    }
}
