package DesignElevator.data;

public class Floor {
    private final Integer floorNumber;
    private final String floorName;

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public String getFloorName() {
        return floorName;
    }

    public Floor(Integer floorNumber, String floorName) {
        this.floorNumber = floorNumber;
        this.floorName = floorName;
    }
}
