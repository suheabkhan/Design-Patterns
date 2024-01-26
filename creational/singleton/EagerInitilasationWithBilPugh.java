package creational.singleton;

public class EagerInitilasationWithBilPugh {

    private EagerInitilasationWithBilPugh(){}

    private static class Helper{
        private static EagerInitilasationWithBilPugh eagerInitilasationWithBilPugh = new EagerInitilasationWithBilPugh();
    }

    public static EagerInitilasationWithBilPugh getInstance(){
        return Helper.eagerInitilasationWithBilPugh;
    }

}
