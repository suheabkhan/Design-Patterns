package structural.flyweight;

public class Balloon {
    private int xCoordinate;
    private int yCoordinate;
    private BalloonFlyweight balloonFlyweight;

    public Balloon(int xCoordinate, int yCoordinate, BalloonFlyweight balloonFlyweight) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.balloonFlyweight = balloonFlyweight;
    }

    @Override
    public String toString() {
        return "Balloon{" +
                "xCoordinate=" + xCoordinate +
                ", yCoordinate=" + yCoordinate +
                ", balloonFlyweight=" + balloonFlyweight +
                '}';
    }

    public BalloonFlyweight getBalloonFlyweight() {
        return balloonFlyweight;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
}
