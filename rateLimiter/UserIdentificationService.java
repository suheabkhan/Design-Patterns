package rateLimiter;

public class UserIdentificationService {
    RateLimiterService rateLimiterService;

    public UserIdentificationService(){
        this.rateLimiterService = new RateLimiterService();
    }
    public synchronized String serveRequest(String clientId){

        boolean isAllowed = rateLimiterService.isRateLimitedUserRequest(clientId);
        if(isAllowed){
            return "Request Served";
        } else return "Too Many Requests please try again";
    }
}
