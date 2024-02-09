package DesignElevator.moveAlgorithm;

import DesignElevator.data.Direction;
import DesignElevator.data.Move;

import java.util.Optional;
import java.util.PriorityQueue;

public class UnidirectionalMove implements moves {

    private final PriorityQueue<Move> upwardMoves;

    private final PriorityQueue<Move> downwardMoves;

    private Direction direction;

    public UnidirectionalMove() {
        // we need to create min heap
        this.upwardMoves = new PriorityQueue<Move>(
                (f1,f2)->
                        f1.getDestinationFloor().getFloorNumber() - f2.getDestinationFloor().getFloorNumber()
        );
        //we need to create max heap
        this.downwardMoves = new PriorityQueue<Move>(
                (f1,f2)->
                        f2.getDestinationFloor().getFloorNumber() - f1.getDestinationFloor().getFloorNumber()
        );
        this.direction=Direction.HALT;
    }

    @Override
    public void addMoves(Move move) {
        if(this.upwardMoves.isEmpty() && this.downwardMoves.isEmpty()){
            this.direction = move.getDestinationDirection();
        }
        if(move.getDestinationDirection().equals(Direction.UP)){
            this.upwardMoves.add(
                    move
            );
        }
        else{
            this.downwardMoves.add(move);
        }

    }

    @Override
    public Move getTopMove() {
        if(upwardMoves.isEmpty() && downwardMoves.isEmpty()){
            return null;
        }
        if(direction.equals(Direction.UP)){
            return this.upwardMoves.peek();
        }
        else{
            return this.downwardMoves.peek();
        }
    }

    @Override
    public void removeTopMoveAfterServed() {
        if(upwardMoves.isEmpty() && downwardMoves.isEmpty()){
            throw new RuntimeException("Illegal operation");
        }
        if(this.direction.equals(Direction.UP)){
            this.upwardMoves.poll();
            if(this.upwardMoves.isEmpty() && !this.downwardMoves.isEmpty()){
                this.direction = Direction.DOWN;
            }
            else{
                this.direction=Direction.HALT;
            }
        }
        else{
            this.downwardMoves.poll();
            if(this.downwardMoves.isEmpty() && !this.upwardMoves.isEmpty()){
                this.direction = Direction.UP;
            }
            else{
                this.direction=Direction.HALT;
            }
        }
    }

    @Override
    public Direction getCurrentDirection() {
        return direction;
    }
}
