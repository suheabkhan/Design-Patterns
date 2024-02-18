package rateLimiter.TokenBucket;

import rateLimiter.RateLimiter;

import java.sql.Timestamp;

/*
   10  , 10  , <=10,
*/
public class TokenBucket implements RateLimiter {
    private final long maxBucketSize;
    private final long refillRate;
    private double currentBucketSize;
    private long lastRefillTimeStamp;

    public TokenBucket(long maxBucketSize, long refillRate){
        this.maxBucketSize = maxBucketSize;
        this.refillRate = refillRate;
        currentBucketSize = maxBucketSize;
        lastRefillTimeStamp = System.currentTimeMillis();
    }

    @Override
    public synchronized boolean allowRequest(){
        refill();
        if(currentBucketSize>=1){
            currentBucketSize-=1;
            //  System.out.print("  current bucket Size: "+currentBucketSize);
            return true;
        }
        return false;
    }

    private synchronized void refill(){
        long now = System.currentTimeMillis();
        //for every one second refilling the token with 10 tokens.. basically 10 requests per second
        // for every one second , there will be a difference of 1000 for (now-lastRefillTimeStamp);
        double tokensToAdd  = (now-lastRefillTimeStamp)*refillRate/1000;
        System.out.println("lastRefillTimeStamp::"+new Timestamp(lastRefillTimeStamp));
        System.out.println("currentTimeStamp::"+new Timestamp(now));
        System.out.println("Rate is ::" +(now-lastRefillTimeStamp)*refillRate);
        System.out.println("Tokens to add are ::" + tokensToAdd);
        System.out.print("before refilled : "+currentBucketSize+"  ");
        currentBucketSize = Math.min(currentBucketSize+tokensToAdd, maxBucketSize);
        System.out.print("After refilled : "+currentBucketSize);
        lastRefillTimeStamp = now;
    }

}
