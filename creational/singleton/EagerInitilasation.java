package creational.singleton;

public class EagerInitilasation {

    // As the name suggests, the object is created eagerly while creating the class

    //create a private constructor so that no one is able to create new object

    private EagerInitilasation(){}

    //create an instance of the class, and assign a new object to it.
    //The instance should be private so that it is not accessed outside the class, so that we are sure, no one will modify it.
    //Also, make it static, so that no new memory used (memory efficient)

    private static EagerInitilasation eagerInitilasation = new EagerInitilasation();

    // make a public method which returns this instance


    public static EagerInitilasation getEagerInitilasation() {
        return eagerInitilasation;
    }
}

// cons:
// Object is created in memory while loading the class itself
// It is created, even if the object is required...