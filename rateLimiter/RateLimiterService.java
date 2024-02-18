package rateLimiter;

import rateLimiter.TokenBucket.TokenBucket;

import java.util.HashMap;

public class RateLimiterService {
    // This will maintain, for which user, what kind of ThrottleRules exists
    HashMap<String, ThrottleRule> clientRulesCache;
    // This will maintain, for which user, which kind of algorithm to be used
    HashMap<String, RateLimiter> rateLimiterHashMap;
    ThrottleRulesService throtleRulesService;

    public RateLimiterService() {
        this.throtleRulesService = ThrottleRulesService.getInstance();
        this.clientRulesCache = new HashMap<>();
        this.rateLimiterHashMap = new HashMap<>();
    }


    public synchronized boolean isRateLimitedUserRequest(String userId) {
        createUserIfNotTheir(userId);
        return rateLimiterHashMap.get(userId).allowRequest();
    }

    private void createUserIfNotTheir(String userId) {
        if (!clientRulesCache.containsKey(userId)) {
            ThrottleRule clientRules = throtleRulesService.getClientRules(userId);
            clientRulesCache.put(userId, clientRules);
        }
        if (!rateLimiterHashMap.containsKey(userId)) {
            ThrottleRule throtleRule = clientRulesCache.get(userId);
            RateLimiter rateLimiter = new TokenBucket(throtleRule.getBucketSize(), throtleRule.getRefillRate());
            rateLimiterHashMap.put(userId, rateLimiter);
        }
    }
}