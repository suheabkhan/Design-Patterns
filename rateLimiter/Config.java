package rateLimiter;

public class Config {
    // Token Bucket
    public static long maxBucketSize = 10;
    public static long refillRate = 10;
    // sliding window
    public static int timeWindowInSeconds = 1;
    public static int bucketSize = 10;
    //For leaky Bucket
    public static int leakyCapacity = 10;
}
