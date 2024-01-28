package behavioural.observer.Notifier;

public class EmailNotify implements Notify{

    @Override
    public void sendMessage(String productCode, String userName,String message) {
        System.out.println("Email sent to "+userName+"."+productCode+","+message);
    }
}
