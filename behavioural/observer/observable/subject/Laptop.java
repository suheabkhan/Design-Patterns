package behavioural.observer.observable.subject;

import java.util.*;

import behavioural.observer.observer.Observer;

public class Laptop implements Subject{

    List<Observer> observers;
    String productCode;
    boolean isProductAvailable=false;

    int stockSize=0;


    public Laptop(String productCode){
        observers = new ArrayList<>();
        this.productCode = productCode;
    }
    
    @Override
    public void register(Observer observer) {
       observers.add(observer);
    }

    @Override
    public void unRegister(Observer observer) {
       observers.remove(observer);
    }

    @Override
    public void notifyUsers(String message) {
       for(Observer user:observers){
        user.update(message,getProductCode());
       }
    }

    public void setAvailability(boolean status){
         if(this.isProductAvailable!=status){
            this.isProductAvailable=status;
            String message = "";
      if(status==false){
         message="product is out of stock";
      }
      else{
         message = "product is available";
      }
      notifyUsers(message);
         }
    }

    public boolean getAvailability(){
      return this.isProductAvailable;
    }

    public String getProductCode(){
      return this.productCode;
    }
    
}
