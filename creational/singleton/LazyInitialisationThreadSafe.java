package creational.singleton;

public class LazyInitialisationThreadSafe {

    // As the name suggests, the object is created lazily whenever it is required

    //create a private constructor so that no one is able to create new object

    private LazyInitialisationThreadSafe(){}

    //create an instance of the class
    //The instance should be private so that it is not accessed outside the class, so that we are sure, no one will modify it.
    //Also, make it static, so that no new memory used (memory efficient)

    private static LazyInitialisationThreadSafe lazyInitilasation;

    // make a public method which returns this instance
    // make this method synchronized, so that only thread gets entered only once

    public synchronized static LazyInitialisationThreadSafe getLazyInitialisation() {
        // create only if its null
        if(lazyInitilasation==null){
            lazyInitilasation = new LazyInitialisationThreadSafe();
        }
        return lazyInitilasation;
    }
    // cons:
    // Since this method is synchronized, in multi threaded environment, it slow downs performance
    // since, synchronized is applied at method level, even in the case the object is already created, only one thread gets
    //executed
}
