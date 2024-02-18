package rateLimiter.slidingwindow;

import rateLimiter.RateLimiter;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/*
  F  .....  R
 */
public class SlidingWindow implements RateLimiter {
    Queue<Long> queue;
    long timeWindowInSeconds;
    long bucketSize;

    public SlidingWindow(long bucketSize, long timeWindowInSeconds) {
        this.timeWindowInSeconds = timeWindowInSeconds;
        this.bucketSize = bucketSize;
        this.queue = new ConcurrentLinkedQueue<Long>();
    }

    @Override
    public synchronized boolean allowRequest() {
        Long currentTime = System.currentTimeMillis();
        checkAndUpdateWindow(currentTime);
        if(queue.size() < bucketSize){
            queue.offer(currentTime);
            return true;
        }
        return false;
    }
    // Will remove all timestamps which fall behind greater than 1 sec
    public synchronized void checkAndUpdateWindow(Long currentTime){
        if(queue.isEmpty()) return;

        long elapsedTime = (currentTime - queue.peek())/1000;
        System.out.println("Time "+elapsedTime);
        while (!queue.isEmpty() && elapsedTime >= timeWindowInSeconds){
            queue.poll();
            System.out.println("QueuePeekTime "+queue.peek());
            if(!queue.isEmpty()) elapsedTime = (currentTime - queue.peek())/1000;
        }
    }
}

//  [ 0.2, 0.3..... 1.0, 1.1]  =  1.1 -0.2 = 0.9
