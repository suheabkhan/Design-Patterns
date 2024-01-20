package structural.observer.observable.subject;

import java.util.*;

import structural.observer.observer.Observer;

public class Laptop implements Subject{

    List<Observer> observers;
    String productCode;
    int stockSize = 0;

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

    public void setStock(int stockSize){
      if(stockSize==0){
         this.stockSize=0;
         }
         else{
            this.stockSize = this.stockSize+stockSize;
         }
         String message = "";
         if(this.stockSize==0){
            message="product is out of stock";
         }
         else{
            message = "product is available";
         }
         notifyUsers(message);
    }

    public int getStock(){
      return this.stockSize;
    }

    public String getProductCode(){
      return this.productCode;
    }
    
}
