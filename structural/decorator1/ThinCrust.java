package structural.decorator1;

public class ThinCrust extends Pizza {

    @Override
    public double getCost() {
        return super.getCost()+50.0;
    }

    @Override
    public String getName() {
        return super.getName()+" Thin Crust";
    }
}
