package behavioural.observer.observer;

import java.util.ArrayList;
import java.util.List;

import behavioural.observer.Notifier.Notify;


public class User implements Observer{

    String userName ;
    List<Notify> notifiers;
    
    public User(String userName){
        this.userName = userName;
        this.notifiers = new ArrayList<>();
    }
    @Override
    public void update(String message,String productCode) {
        for(Notify notify:this.notifiers){
            notify.sendMessage(productCode, userName, message);
        }
    }

    public void addNotificationOptions(Notify notificationType){
        this.notifiers.add(notificationType);
    }

}
