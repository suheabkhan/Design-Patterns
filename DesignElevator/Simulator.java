package DesignElevator;

import DesignElevator.data.Direction;
import DesignElevator.data.Floor;
import DesignElevator.elev.Elevator;
import DesignElevator.moveAlgorithm.UnidirectionalMove;
import DesignElevator.state.IdleState;

public class Simulator {
    public static void main(String[] args) {
        Elevator elevator = new Elevator(new UnidirectionalMove());
        elevator.setElevatorState(new IdleState(elevator));

        elevator.setFloor(new Floor(0,"Ground"));
        elevator.destine(new Floor(4, "fourth"),Direction.UP);

        System.out.println(elevator.getElevatorState().getState());
        elevator.destine(new Floor(7,"seventh"),Direction.UP);

        elevator.setFloor(new Floor(3,"third"));

        elevator.destine(new Floor(1,"first"),Direction.DOWN);

        elevator.setFloor(new Floor(4,"fourth"));

        elevator.stop(new Floor(4,"fourth"));
        System.out.println(elevator.getElevatorState().getState());

        elevator.open(new Floor(4,"fourth"));

        System.out.println(elevator.getElevatorState().getState());

        elevator.close(new Floor(4,"fourth"));

        System.out.println(elevator.getMoveStore().getTopMove().getDestinationFloor().getFloorNumber()+" " +
                ""+elevator.getMoveStore().getTopMove().getDestinationDirection());

        elevator.destine(new Floor(3,"third"),Direction.DOWN);

        elevator.setFloor(new Floor(7,"seventh"));

        elevator.stop(new Floor(7,"seventh"));

        System.out.println(elevator.getElevatorState().getState());

        elevator.open(new Floor(7,"seventh"));

        System.out.println(elevator.getElevatorState().getState());

        elevator.close(new Floor(7,"seventh"));

        System.out.println(elevator.getElevatorState().getState());

        System.out.println(elevator.getMoveStore().getTopMove().getDestinationFloor().getFloorNumber()+" " +
                ""+elevator.getMoveStore().getTopMove().getDestinationDirection());


    }
}
