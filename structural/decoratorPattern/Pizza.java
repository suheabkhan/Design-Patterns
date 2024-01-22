package structural.decoratorPattern;

public abstract class Pizza {

    private final String name;

    private final double price;

    protected Pizza(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
