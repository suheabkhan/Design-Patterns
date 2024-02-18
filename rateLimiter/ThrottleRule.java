package rateLimiter;

// what should be your bucketSize and refillRate
public class ThrottleRule {
    public long bucketSize;
    public long refillRate;

    public ThrottleRule(){
        this.bucketSize = Config.bucketSize;
        this.refillRate = Config.refillRate;
    }

    public ThrottleRule(long bucketSize, long refillRate) {
        this.bucketSize = bucketSize;
        this.refillRate = refillRate;
    }

    public long getBucketSize() {
        return bucketSize;
    }

    public long getRefillRate() {
        return refillRate;
    }
}
