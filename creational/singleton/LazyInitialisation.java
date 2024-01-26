package creational.singleton;

public class LazyInitialisation {

    // As the name suggests, the object is created lazily whenever it is required

    //create a private constructor so that no one is able to create new object

    private LazyInitialisation(){}

    //create an instance of the class
    //The instance should be private so that it is not accessed outside the class, so that we are sure, no one will modify it.
    //Also, make it static, so that no new memory used (memory efficient)

    private static LazyInitialisation lazyInitilasation;

    // make a public method which returns this instance


    public static LazyInitialisation getLazyInitialisation() {
        // create only if its null
        if(lazyInitilasation==null){
         lazyInitilasation = new LazyInitialisation();
        }
        return lazyInitilasation;
    }

}
