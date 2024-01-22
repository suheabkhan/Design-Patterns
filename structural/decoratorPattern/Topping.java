package structural.decoratorPattern;

public class Topping extends Pizza{

    private final Pizza pizza;

    public Topping(String name, double price, Pizza pizza) {
        //create a pizza with olive topping and price
        super(name, price);
        //old pizza, may be thin crust pizza at first
        this.pizza = pizza;
    }

    @Override
    public String getName() {
        return super.getName() + " "+pizza.getName();
    }

    @Override
    public double getPrice() {
        return super.getPrice()+ pizza.getPrice();
    }
}
