package TicTacToe.exceptions;

public class NoMoveToUndoException extends Exception{
    public NoMoveToUndoException() {
        super("No Move Exists to Undo");
    }
}
