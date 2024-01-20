package structural.observer.observable.subject;

import structural.observer.observer.Observer;

public interface Subject {

    void register(Observer observer);

    void unRegister(Observer observer);

    void notifyUsers(String message);
    
    String getProductCode();

    void setStock(int stock);

    int getStock();
}
