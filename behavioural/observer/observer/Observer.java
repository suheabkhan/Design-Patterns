
package behavioural.observer.observer;

import behavioural.observer.Notifier.Notify;

public interface Observer{

    void update(String message,String productCode);

    void addNotificationOptions(Notify emailNotifier);

}