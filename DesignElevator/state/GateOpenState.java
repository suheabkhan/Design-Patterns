package DesignElevator.state;

import DesignElevator.data.Direction;
import DesignElevator.data.Floor;
import DesignElevator.data.State;
import DesignElevator.elev.Elevator;

public class GateOpenState implements ElevatorState{

    // In this state, only one operation is allowed, which is the closeState. All other operations should throw error

    private final Elevator elevator;

    public GateOpenState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void destine(Floor floor, Direction direction) {
        throw new RuntimeException("Illegal operation");
    }

    @Override
    public void open(Floor floor) {
        throw new RuntimeException("Illegal operation");
    }

    @Override
    public void close(Floor floor) {
    // whenever we close the elevator gate, then we need to know where to go to which floor and which direction.
        Direction directionToMove = this.elevator.getMoveStore().getCurrentDirection();
        if(directionToMove.equals(Direction.UP)){
           this.elevator.setElevatorState(new MovingUpState(elevator));
        }
        else if(directionToMove.equals(Direction.DOWN)){
            this.elevator.setElevatorState(new MovingDownState(elevator));
        }
        else if(directionToMove.equals(Direction.HALT)){
            this.elevator.setElevatorState(new IdleState(elevator));
        }
        else{
            throw new RuntimeException("Unsupported Enums");
        }
    }

    @Override
    public void stop(Floor floor) {
        throw new RuntimeException("Illegal operation");
    }

    @Override
    public State getState() {
        return State.GATEOPEN;
    }
}
