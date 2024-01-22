package structural.decoratorPattern;

public class Olive extends Topping{
    public Olive(Pizza pizza) {
        super("olive", 10.0, pizza);
    }
}
