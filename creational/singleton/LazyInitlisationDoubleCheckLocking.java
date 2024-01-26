package creational.singleton;

public class LazyInitlisationDoubleCheckLocking {

    // As the name suggests, the object is created lazily whenever it is required

    //create a private constructor so that no one is able to create new object

    private LazyInitlisationDoubleCheckLocking(){}

    //create an instance of the class
    //The instance should be private so that it is not accessed outside the class, so that we are sure, no one will modify it.
    //Also, make it static, so that no new memory used (memory efficient)

    private static LazyInitlisationDoubleCheckLocking lazyInitilasation;

    // make a public method which returns this instance
    // make this method synchronized, so that only thread gets entered only once

    public static LazyInitlisationDoubleCheckLocking getLazyInitialisation() {
        // create only if its null
        if(lazyInitilasation==null){ // check-1
            synchronized (LazyInitlisationDoubleCheckLocking.class){
                if(lazyInitilasation==null){ //check-2
                    lazyInitilasation = new LazyInitlisationDoubleCheckLocking();
                }
            }
        }
        return lazyInitilasation;
    }
    //since we are using synchronized at block level, there might be an issue when we want to assign something.
    // there can be issue with statement reordering in multithreaded envirionment
}
