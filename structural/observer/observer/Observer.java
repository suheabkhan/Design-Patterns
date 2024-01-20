
package structural.observer.observer;

import structural.observer.Notifier.Notify;

public interface Observer{

    void update(String message,String productCode);

    void addNotificationOptions(Notify emailNotifier);

}