package structural.decoratorPattern;

public class Tester {
    public static void main(String[] args) {
        Pizza pizza = new Mushroom(new Olive(new ThinCrust()));
        System.out.println(pizza.getName() +" -- "+pizza.getPrice());
    }
}
