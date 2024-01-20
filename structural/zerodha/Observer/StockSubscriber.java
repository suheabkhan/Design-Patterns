package structural.zerodha.Observer;

import structural.zerodha.StockName;
import structural.zerodha.StockPrice;

public interface StockSubscriber {

    void updateStock(StockName name, StockPrice price);

    void printStocks();
}
