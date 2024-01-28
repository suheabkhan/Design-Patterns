package behavioural.loggers;

public class ConsoleSubscriber implements Subscriber{

    @Override
    public void publish(String message) {
        System.out.println(message);
    }

}
