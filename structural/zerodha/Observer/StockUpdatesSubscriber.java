package structural.zerodha.Observer;

import structural.zerodha.Observerable.StockPublisher;
import structural.zerodha.StockName;
import structural.zerodha.StockPrice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockUpdatesSubscriber implements StockSubscriber{

    private final String name;

    private final Map<StockName, StockPrice> stocksValues;


    public StockUpdatesSubscriber(String name) {
        this.name = name;
        this.stocksValues = new HashMap<>();
    }

    @Override
    public void updateStock(StockName stockName, StockPrice price) {
        //Need to handle the concurreny in multi threaded envirinment
        //update the map if stock does not exist, or if the versionnumber of new stock is greater than the old one
        if(!stocksValues.containsKey(stockName) || stocksValues.get(stockName).getVersionNumber()<price.getVersionNumber()){
            System.out.println(name +" "+stockName+" "+price.getAmount() +" "+price.getCurrency()+" "+price.getVersionNumber());
            stocksValues.put(stockName,price);
        }
    }

    @Override
    public void printStocks(){
        for(Map.Entry<StockName,StockPrice> entry:stocksValues.entrySet()){
            System.out.println(entry.getKey()+" -- "+entry.getValue());
        }
    }
}
