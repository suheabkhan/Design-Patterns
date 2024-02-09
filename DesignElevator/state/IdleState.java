package DesignElevator.state;

import DesignElevator.data.Direction;
import DesignElevator.data.Floor;
import DesignElevator.data.Move;
import DesignElevator.data.State;
import DesignElevator.elev.Elevator;

import java.util.Optional;

public class IdleState implements ElevatorState{

    private final Elevator elevator;

    public IdleState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void destine(Floor floor, Direction direction) {
        // This is while in IDLE state , we get a new request, we need to add it in the move store
        this.elevator.getMoveStore().addMoves(new Move(floor,direction));
        Move currentMove = this.elevator.getMoveStore().getTopMove();
        if(currentMove==null){
            throw new RuntimeException("No Moves exist");
        }
        Direction topMoveDirection = currentMove.getDestinationDirection();
        // check after adding, if we the new request priority is to go down, then set it to MovingDownState
        if(topMoveDirection.equals(Direction.UP)){
            this.elevator.setElevatorState(new MovingUpState(elevator));
        }
        else if(topMoveDirection.equals(Direction.DOWN)){
            this.elevator.setElevatorState(new MovingDownState(elevator));
        }
        else{
            throw new RuntimeException("Unsupported ENUM");
        }
    }

    @Override
    public void open(Floor floor) {
       this.elevator.setElevatorState(new GateOpenState(elevator));
    }

    @Override
    public void close(Floor floor) {
        throw new RuntimeException("Elevator is already in the IDLE state,so cannot close");
    }

    @Override
    public void stop(Floor floor) {
        throw new RuntimeException("Elevator is already in the IDLE state, so cannot stop");
    }

    @Override
    public State getState() {
        return State.IDLE;
    }
}
