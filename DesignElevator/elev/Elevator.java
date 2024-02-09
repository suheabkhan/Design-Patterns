package DesignElevator.elev;

import DesignElevator.data.Direction;
import DesignElevator.data.Floor;
import DesignElevator.data.Move;
import DesignElevator.moveAlgorithm.moves;
import DesignElevator.state.ElevatorState;

public class Elevator {

    private Floor floor;

    private ElevatorState elevatorState;

    private final moves moveStore;

    public moves getMoveStore() {
        return moveStore;
    }

    public Elevator(moves moveStore) {
        this.moveStore = moveStore;
    }

    public ElevatorState getElevatorState() {
        return elevatorState;
    }

    public void setElevatorState(ElevatorState elevatorState) {
        this.elevatorState = elevatorState;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public void destine(Floor floor , Direction direction){
        this.elevatorState.destine(floor,direction);
    }

    public void open(Floor floor){
        this.elevatorState.open(floor);
    }

    public void close(Floor floor){
        this.elevatorState.close(floor);
    }

    public void stop(Floor floor){
        this.elevatorState.stop(floor);
    }
}
