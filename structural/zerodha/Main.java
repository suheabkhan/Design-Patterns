package structural.zerodha;

import structural.zerodha.Observer.StockSubscriber;
import structural.zerodha.Observer.StockUpdatesSubscriber;
import structural.zerodha.Observerable.StockPublisher;
import structural.zerodha.Observerable.StockUpdatesPublisher;

public class Main {

    public static void main(String[] args) {
        StockPublisher bse = new StockUpdatesPublisher("BSE");
        StockPublisher nse = new StockUpdatesPublisher("NSE");
        StockSubscriber subscriber1 = new StockUpdatesSubscriber("subscriber1");
        StockSubscriber subscriber2 = new StockUpdatesSubscriber("subscriber2");
        StockSubscriber subscriber3 = new StockUpdatesSubscriber("subscriber3");
        bse.register(subscriber1);
        bse.register(subscriber2);
        nse.register(subscriber1);
        nse.register(subscriber3);
        System.out.println("============================================================");
        bse.notify(StockName.AMAZON,new StockPrice(100,1,Currency.RS));
        System.out.println("============================================================");
        bse.notify(StockName.AMAZON,new StockPrice(200,2,Currency.RS));
        System.out.println("============================================================");
        nse.notify(StockName.AMAZON,new StockPrice(100,1,Currency.RS));
        System.out.println("============================================================");
        bse.notify(StockName.NETFLIX,new StockPrice(300,1,Currency.RS));
        System.out.println("============================================================");
        subscriber1.printStocks();
        System.out.println("============================================================");
        subscriber2.printStocks();
        System.out.println("============================================================");
        subscriber3.printStocks();
        System.out.println("============================================================");

    }
}
