package structural.observer.Notifier;

public class SmsNotify implements Notify{

    @Override
    public void sendMessage(String productCode, String userName,String message) {
        System.out.println("SMS sent to "+userName+"."+productCode+","+message);
    }
    
}
