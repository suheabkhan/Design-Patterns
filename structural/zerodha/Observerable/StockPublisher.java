package structural.zerodha.Observerable;

import structural.zerodha.Observer.StockSubscriber;
import structural.zerodha.StockName;
import structural.zerodha.StockPrice;

public interface StockPublisher {
    void register(StockSubscriber subscriber);

    void unregister(StockSubscriber subscriber);

    void notify(StockName name, StockPrice price);
}
