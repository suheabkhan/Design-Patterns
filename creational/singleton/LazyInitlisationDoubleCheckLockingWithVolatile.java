package creational.singleton;

public class LazyInitlisationDoubleCheckLockingWithVolatile {
    // As the name suggests, the object is created lazily whenever it is required

    //create a private constructor so that no one is able to create new object

    private LazyInitlisationDoubleCheckLockingWithVolatile(){}

    //create an instance of the class
    //The instance should be private so that it is not accessed outside the class, so that we are sure, no one will modify it.
    //Also, make it static, so that no new memory used (memory efficient)
    // with the use of volatile keyword, the values aRE directly read from memory not from L1 cache. No Race conditions
    private static volatile LazyInitlisationDoubleCheckLockingWithVolatile lazyInitilasation;

    // make a public method which returns this instance
    // make this method synchronized, so that only thread gets entered only once

    public static LazyInitlisationDoubleCheckLockingWithVolatile getLazyInitialisation() {
        // create only if its null
        if(lazyInitilasation==null){ // check-1
            synchronized (LazyInitlisationDoubleCheckLockingWithVolatile.class){
                if(lazyInitilasation==null){ //check-2
                    lazyInitilasation = new LazyInitlisationDoubleCheckLockingWithVolatile();
                }
            }
        }
        return lazyInitilasation;
    }
}
