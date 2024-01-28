package structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    private static final Map<String,BalloonFlyweight> cacheFactory = new HashMap<>();

    public static BalloonFlyweight factory(String color,String imagePath,int points){
        if(!cacheFactory.containsKey(color)){
            cacheFactory.put(color,new BalloonFlyweight(color,imagePath,points));
        }
        return cacheFactory.get(color);
    }
}
