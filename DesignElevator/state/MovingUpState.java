package DesignElevator.state;

import DesignElevator.data.Direction;
import DesignElevator.data.Floor;
import DesignElevator.data.Move;
import DesignElevator.data.State;
import DesignElevator.elev.Elevator;

public class MovingUpState implements ElevatorState{


    private final Elevator elevator;

    public MovingUpState(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void destine(Floor floor, Direction direction) {
      // This is while moving up, we get a new request, we need to add it in the move store
      this.elevator.getMoveStore().addMoves(new Move(floor,direction));
        Move currentMove = this.elevator.getMoveStore().getTopMove();
        if(currentMove==null){
            throw new RuntimeException("No Moves exist");
        }
        Direction topMoveDirection = currentMove.getDestinationDirection();
      // check after adding, if we the new request priority is to go down, then set it to MovingDownState
      if(topMoveDirection.equals(Direction.DOWN)){
             this.elevator.setElevatorState(new MovingDownState(elevator));
      }
    }

    @Override
    public void open(Floor floor) {
        throw new RuntimeException("Cannot open elevator while movingup");
    }

    @Override
    public void close(Floor floor) {
        throw new RuntimeException("Cannot close elevator while movingdown");
    }

    @Override
    public void stop(Floor floor) {
      // If the elevator is stopped at this floor, then we need to remove the top floor
        this.elevator.getMoveStore().removeTopMoveAfterServed();
        System.out.println("Elevator stopped at ::"+floor.getFloorNumber());
        this.elevator.setElevatorState(new IdleState(elevator));
        System.out.println("Elevator set to idle state at ::"+floor.getFloorNumber());
    }

    @Override
    public State getState() {
        return State.MOVINGUP;
    }
}
