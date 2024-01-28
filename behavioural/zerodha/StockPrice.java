package behavioural.zerodha;

public class StockPrice {
    private final double amount;
    private final int versionNumber;
    private final Currency currency;

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "StockPrice{" +
                "amount=" + amount +
                ", versionNumber=" + versionNumber +
                ", currency=" + currency +
                '}';
    }

    public int getVersionNumber() {
        return versionNumber;
    }

    public Currency getCurrency() {
        return currency;
    }

    public StockPrice(double amount, int versionNumber, Currency currency) {
        this.amount = amount;
        this.versionNumber = versionNumber;
        this.currency = currency;
    }
}
