package creational.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) {

        /**
         *         EagerInitilasation eagerInitilasation1 = EagerInitilasation.getEagerInitilasation();
         *         System.out.println(eagerInitilasation1);
         *         EagerInitilasation eagerInitilasation2 = EagerInitilasation.getEagerInitilasation();
         *         System.out.println(eagerInitilasation2);
         *         Both the objects created will return the single instance, no matter how many times they are created
         *
         *
         *         ExecutorService executorService = Executors.newFixedThreadPool(3);
         *         for(int i = 0;i<5;i++){
         *             executorService.execute(()->{
         *                 System.out.println("Printing document by thread : "
         *                         + Thread.currentThread().getName());
         *                 System.out.println(EagerInitilasation.getEagerInitilasation());
         *             });
         *         }
         *
         *         // Here everytime the same object is printed, even if multiple threads access it. Therefore, threadsafe
         * **/

        /**
         *  Lazy Initialisation
         *
         * LazyInitialisation lazyInitialisation1 = LazyInitialisation.getLazyInitialisation();
         *         LazyInitialisation lazyInitialisation2 = LazyInitialisation.getLazyInitialisation();
         *         System.out.println(lazyInitialisation1);
         *         System.out.println(lazyInitialisation2);
         *  // Both the objects will have the same instance
         *
         * ExecutorService executorService = Executors.newFixedThreadPool(3);
         *         for(int i =0;i<3;i++){
         *             executorService.execute(()->{
         *                 System.out.println("Printing document by thread : "+Thread.currentThread().getName());
         *                 LazyInitialisation lazyInitialisation =  LazyInitialisation.getLazyInitialisation();
         *                 System.out.println(lazyInitialisation);
         *             });
         *         }
         *         Printing document by thread : pool-1-thread-3
         *         Printing document by thread : pool-1-thread-1
         *         Printing document by thread : pool-1-thread-2
         *         creational.singleton.LazyInitialisation@78c378d5
         *         creational.singleton.LazyInitialisation@2c5084bf
         *         creational.singleton.LazyInitialisation@2c5084bf
         *
         *         // Here we can see LazyInitilaisation is not thread safe
         * **/

        /**
        LazyInitialisationThreadSafe lazyInitialisationThreadSafe1 = LazyInitialisationThreadSafe.getLazyInitialisation();
        LazyInitialisationThreadSafe lazyInitialisationThreadSafe2 = LazyInitialisationThreadSafe.getLazyInitialisation();
        System.out.println(lazyInitialisationThreadSafe1);
        System.out.println(lazyInitialisationThreadSafe2);
        // Here both will have the same output

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for(int i =0;i<3;i++){
            executorService.execute(()->{
                System.out.println("Printing document by thread : "+Thread.currentThread().getName());
                LazyInitialisationThreadSafe lazyInitialisationThreadSafe = LazyInitialisationThreadSafe.getLazyInitialisation();
                System.out.println(lazyInitialisationThreadSafe);
            });

        }
        Printing document by thread : pool-1-thread-3
        Printing document by thread : pool-1-thread-1
        Printing document by thread : pool-1-thread-2
        creational.singleton.LazyInitialisationThreadSafe@58372a00
        creational.singleton.LazyInitialisationThreadSafe@58372a00
        Here we can see it's threadsafe
        **/


        /**LazyInitlisationDoubleCheckLocking lazyInitialisationThreadSafe1 = LazyInitlisationDoubleCheckLocking.getLazyInitialisation();
        LazyInitlisationDoubleCheckLocking lazyInitialisationThreadSafe2 = LazyInitlisationDoubleCheckLocking.getLazyInitialisation();
        System.out.println(lazyInitialisationThreadSafe1);
        System.out.println(lazyInitialisationThreadSafe2);
        // Here both will have the same output

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for(int i =0;i<3;i++){
            executorService.execute(()->{
                System.out.println("Printing document by thread : "+Thread.currentThread().getName());
                LazyInitlisationDoubleCheckLocking lazyInitialisationThreadSafe = LazyInitlisationDoubleCheckLocking.getLazyInitialisation();
                System.out.println(lazyInitialisationThreadSafe);
            });
        }**/

        /**LazyInitlisationDoubleCheckLockingWithVolatile lazyInitialisationThreadSafe1 = LazyInitlisationDoubleCheckLockingWithVolatile.getLazyInitialisation();
        LazyInitlisationDoubleCheckLockingWithVolatile lazyInitialisationThreadSafe2 = LazyInitlisationDoubleCheckLockingWithVolatile.getLazyInitialisation();
        System.out.println(lazyInitialisationThreadSafe1);
        System.out.println(lazyInitialisationThreadSafe2);
        // Here both will have the same output

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for(int i =0;i<3;i++){
            executorService.execute(()->{
                System.out.println("Printing document by thread : "+Thread.currentThread().getName());
                LazyInitlisationDoubleCheckLockingWithVolatile lazyInitialisationThreadSafe = LazyInitlisationDoubleCheckLockingWithVolatile.getLazyInitialisation();
                System.out.println(lazyInitialisationThreadSafe);
            });
        }

        Printing document by thread : pool-1-thread-3
        Printing document by thread : pool-1-thread-2
        creational.singleton.LazyInitlisationDoubleCheckLockingWithVolatile@58372a00
        Printing document by thread : pool-1-thread-1
        creational.singleton.LazyInitlisationDoubleCheckLockingWithVolatile@58372a00
        creational.singleton.LazyInitlisationDoubleCheckLockingWithVolatile@58372a00
         // Hence threadsafe
         **/
        /**
        EagerInitilasationWithBilPugh eagerInitilasationWithBilPugh1 = EagerInitilasationWithBilPugh.getInstance();
        EagerInitilasationWithBilPugh eagerInitilasationWithBilPugh2 = EagerInitilasationWithBilPugh.getInstance();
        System.out.println(eagerInitilasationWithBilPugh1);
        System.out.println(eagerInitilasationWithBilPugh2);
        // Here both will have the same output

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for(int i =0;i<3;i++){
            executorService.execute(()->{
                System.out.println("Printing document by thread : "+Thread.currentThread().getName());
                EagerInitilasationWithBilPugh eagerInitilasationWithBilPugh = EagerInitilasationWithBilPugh.getInstance();
                System.out.println(eagerInitilasationWithBilPugh);
            });
        }
        Printing document by thread : pool-1-thread-3
        Printing document by thread : pool-1-thread-2
        creational.singleton.EagerInitilasationWithBilPugh@4dd8dc3
        creational.singleton.EagerInitilasationWithBilPugh@4dd8dc3
        Printing document by thread : pool-1-thread-1
        creational.singleton.EagerInitilasationWithBilPugh@4dd8dc3
            //Hence Threadsafe
        **/
    }
}
