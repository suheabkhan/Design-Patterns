package structural.decoratorPattern;

public class Mushroom extends Topping{
    public Mushroom(Pizza pizza) {
        super("mushroom", 20.0, pizza);
    }
}
