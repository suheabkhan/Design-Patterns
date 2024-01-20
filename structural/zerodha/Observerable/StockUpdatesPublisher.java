package structural.zerodha.Observerable;

import structural.zerodha.Observer.StockSubscriber;
import structural.zerodha.StockName;
import structural.zerodha.StockPrice;

import java.util.ArrayList;
import java.util.List;

public class StockUpdatesPublisher implements StockPublisher{

    // Instead of creating a class for different stockExchanges / Products since all they do is the same,
    // can use one class and change the state details of name
    // Improvement from the
    private final String name;
    List<StockSubscriber> subscriberList;

    public StockUpdatesPublisher(String name){
        this.name = name;
        subscriberList= new ArrayList<>();

    }
    @Override
    public void register(StockSubscriber subscriber) {
        subscriberList.add(subscriber);
    }

    @Override
    public void unregister(StockSubscriber subscriber) {
       subscriberList.remove(subscriber);
    }

    @Override
    public void notify(StockName name, StockPrice price) {
         for(StockSubscriber subscriber:subscriberList){
              subscriber.updateStock(name,price);
         }
    }
}
