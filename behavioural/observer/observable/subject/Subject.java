package behavioural.observer.observable.subject;

import behavioural.observer.observer.Observer;

public interface Subject {

    void register(Observer observer);

    void unRegister(Observer observer);

    void notifyUsers(String message);
    
    String getProductCode();

    void setAvailability(boolean status);

    boolean getAvailability();
}
