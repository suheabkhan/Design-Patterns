package structural.flyweight;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * Flyweight design pattern is a pattern where it lets you fit more objects into the RAM by sharing common attributes/parts of the
 * object instead of the creating new common parts for the every new object.
 *Stop sharing the rarely changing objects in the same object, instead move it to a new object
 * Flyweight objects are immutable, stores intrinsic objects, the state is context independent, sharable and never altered
 * at run time. There fore no setters for flyweight class
 * Move the common data to the flyweight class
 * The other unique properties will stay in the initial class
 * We will have a flyweight factory, which returns the possible flyweight object
 * keep in mind that the flyeweight design pattern is an optimization...before applying th epattern, make sure we have the
 * RAM consumption related due to massive number of objects
 * For example::
 * Lets consider a balloon buster game
 * It consists of five coloured balloons, blue,red,yellow,green,orange..
 * A balloon can come from any where from the screen and we need to burst it....
 * Each balloon will have the name,image commonn for each balloon of each category ... (Green balloon, name:green,image:pathOfGreen)
 * These common attributes are called intrinsic properties
 * The other attributes are called extrinsic properties
 **/
public class Main {
    private static Map<String,String> urlMap = new HashMap<>();
    private static String[] colors = {
      "green",
      "orange",
      "red",
      "pink",
      "blue"
    };
    public static void main(String[] args) {
        List<Balloon> balloonList = new ArrayList<>();
        for(int i =0;i<10;i++){
            String color = getColor();
            String url = urlMap.get(color);
            BalloonFlyweight balloonFlyweight = FlyweightFactory.factory(color,url,100);
            Balloon balloon = new Balloon((int) (Math.random()* 50),
                    (int) (Math.random()* 50),
                    balloonFlyweight);
            balloonList.add(balloon);
        }
        for(Balloon balloon:balloonList){
            System.out.println(balloon);
        }
    }

    static{
        urlMap.put("green","url1");
        urlMap.put("blue","url2");
        urlMap.put("red","url3");
        urlMap.put("orange","url4");
        urlMap.put("pink","url5");
    }

    public static String getColor(){
        return colors[(int)(Math.random()* colors.length)];
    }
}
