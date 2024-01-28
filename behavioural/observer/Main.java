package behavioural.observer;

import behavioural.observer.Notifier.EmailNotify;
import behavioural.observer.Notifier.Notify;
import behavioural.observer.Notifier.SmsNotify;
import behavioural.observer.observable.subject.Laptop;
import behavioural.observer.observable.subject.Phone;
import behavioural.observer.observable.subject.Subject;
import behavioural.observer.observer.Observer;
import behavioural.observer.observer.User;

public class Main {
    public static void main(String[] args) {
        Notify emailNotifier = new EmailNotify();
        Notify smsNotifier = new SmsNotify();

        Subject laptopObject = new Laptop("LENOVO-A60");
        Subject phoneObject = new Phone("MOTO G54");
        
        Observer user1 = new User("suheab");
        user1.addNotificationOptions(emailNotifier);
        Observer user2 = new User("muddu");
        user2.addNotificationOptions(smsNotifier);
        Observer user3 = new User("mujju");
        user3.addNotificationOptions(emailNotifier);
        user3.addNotificationOptions(smsNotifier);

        laptopObject.register(user1);
        laptopObject.register(user2);
        phoneObject.register(user1);
        phoneObject.register(user3);

        System.out.println("--------------------------");
        laptopObject.setAvailability(true);
        System.out.println("--------------------------");
        phoneObject.setAvailability(true);
        System.out.println("--------------------------");
        laptopObject.setAvailability(true);
        System.out.println("--------------------------");
        phoneObject.setAvailability(false);
        System.out.println("--------------------------");
        laptopObject.setAvailability(false);

    }
}
