package rateLimiter;

import java.util.HashMap;

public class ThrottleRulesService {

    HashMap<String,ThrottleRule> clientThrottleRules;
    private static volatile ThrottleRulesService instance;

    public ThrottleRulesService() {
        this.clientThrottleRules = new HashMap<>();
    }

    public void createRule(String clientId, ThrottleRule throtleRule){
        clientThrottleRules.put(clientId, throtleRule);
    }

    public ThrottleRule getClientRules(String clientId){
        return clientThrottleRules.get(clientId);
    }

    public static ThrottleRulesService getInstance(){
        if(instance==null){
            synchronized (ThrottleRulesService.class){
                if(instance==null){
                    instance = new ThrottleRulesService();
                }
            }
        }
        return instance;
    }
}
