package structural.observer.observable.subject;

import java.util.*;

import structural.observer.observer.Observer;

public class Phone implements Subject{

    List<Observer> observers;

    int stockSize =0;

    String productCode;

    boolean isProductAvailable=false;

    public Phone(String productCode){
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
   if(!status){
      message="product is out of stock";
   }
   else{
      message = "product is available";
   }
   notifyUsers(message);
      }
 }

    
    public String getProductCode(){
      return this.productCode;
    }

    public boolean getAvailability(){
      return this.isProductAvailable;
    }

}

