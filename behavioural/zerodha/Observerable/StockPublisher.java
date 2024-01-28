package behavioural.zerodha.Observerable;

import behavioural.zerodha.Observer.StockSubscriber;
import behavioural.zerodha.StockName;
import behavioural.zerodha.StockPrice;

public interface StockPublisher {
    void register(StockSubscriber subscriber);

    void unregister(StockSubscriber subscriber);

    void notify(StockName name, StockPrice price);
}
