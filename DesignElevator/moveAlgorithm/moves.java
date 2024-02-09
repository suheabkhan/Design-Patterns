package DesignElevator.moveAlgorithm;

import DesignElevator.data.Direction;
import DesignElevator.data.Move;

import java.util.Optional;

public interface moves {
    // add a new move/request
    void addMoves(Move move);

    //get next move/ floor request
    Move getTopMove();

    //after request is served, remove it
    void removeTopMoveAfterServed();

    //get the currentDirection of elevator
    Direction getCurrentDirection();
}
