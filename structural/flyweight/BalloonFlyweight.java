package structural.flyweight;

public class BalloonFlyweight {
    private String color;
    private String image;
    private int points;

    @Override
    public String toString() {
        return "BalloonFlyweight{" +
                "color='" + color + '\'' +
                ", image='" + image + '\'' +
                ", points=" + points +
                ",address="+this.getClass().getName() + "@" +
                Integer.toHexString(System.identityHashCode(this))+
                '}';
    }

    public String getColor() {
        return color;
    }

    public String getImage() {
        return image;
    }

    public int getPoints() {
        return points;
    }

    public BalloonFlyweight(String color, String image, int points) {
        this.color = color;
        this.image = image;
        this.points = points;
    }
}
