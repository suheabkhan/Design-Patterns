package behavioural.zerodha.Observer;

import behavioural.zerodha.StockName;
import behavioural.zerodha.StockPrice;

public interface StockSubscriber {

    void updateStock(StockName name, StockPrice price);

    void printStocks();
}
