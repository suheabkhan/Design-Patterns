package TicTacToe.strategies.gamewinningstratgeies;

import TicTacToe.models.Board;
import TicTacToe.models.Move;

public interface GameWinningStrategy {
    boolean checkVictory(Board board, Move move);
}
