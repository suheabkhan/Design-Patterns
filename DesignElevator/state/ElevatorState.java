package DesignElevator.state;

import DesignElevator.data.Direction;
import DesignElevator.data.Floor;
import DesignElevator.data.State;


// Currently we have 4 different states
/**
 * IDle state
 * MOVINGUP state
 * MOVINGDOWN state
 * GATEOPEN state
 *
 * IDLE state -> someone calls the gateopen state then the elevator will go into the gateopen state (If floor from which gateopen
 *               is pressed and the elevator are on the same floor, it will just open the floor, it doesnot need to go up/down)
 *            -> Someone calls the destine state then the elevator will go to the movingUP state or movingdown state
 *               (For example, if the elevator is in the ground floor, someone presses opengate button from outside from 4 floor
 *               then the elevator is in the movingup state)
 * MOVINGUP/MOVINGDOWN state -> stop elevator state
 * GATEOPEN state -> should check if there are any further requests to be served, if yes serve them else stay back in IDLE state
 * Currently in our design/algorithm, if the elevator is moving up, then it should serve all the requests in the same direction, then after all
 * movingup requests are done, it should serve moving down requests.But in future, if we want to change the algorithm, we should be
 * able to do it, where in between if a high priority requests come from moving down direction, then it should serve that first, then
 * it should serve the other pending requests
 */
public interface ElevatorState {

    void destine(Floor floor, Direction direction);

    void open(Floor floor);

    void close(Floor floor);

    void stop(Floor floor);
    // TO check what is the current state of my elevator
    State getState();
}
