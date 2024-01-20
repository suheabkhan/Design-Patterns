package structural.observer;

import structural.observer.Notifier.EmailNotify;
import structural.observer.Notifier.Notify;
import structural.observer.Notifier.SmsNotify;
import structural.observer.observable.subject.Laptop;
import structural.observer.observable.subject.Phone;
import structural.observer.observable.subject.Subject;
import structural.observer.observer.Observer;
import structural.observer.observer.User;

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
