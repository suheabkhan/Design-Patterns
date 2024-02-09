package TicTacToe.strategies.gamewinningstratgeies;

import TicTacToe.models.Board;
import TicTacToe.models.Move;

public class RowWinningStrategy implements GameWinningStrategy {
    @Override
    public boolean checkVictory(Board board, Move move) {
        return false;
    }
}
