package TicTacToe.strategies.botplayingstrategies;

import TicTacToe.exceptions.InvalidMoveException;
import TicTacToe.models.Board;
import TicTacToe.models.Move;
import TicTacToe.models.Player;

import java.util.concurrent.ThreadLocalRandom;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {

    @Override
    public Move makeMove(Board board, Player player) {
        int dimension = board.getDimension();
        int moveRow=-1;
        int moveColumn=-1;
        while(true){
            moveRow = ThreadLocalRandom.current().nextInt(0, dimension );
            moveColumn = ThreadLocalRandom.current().nextInt(0, dimension);
            System.out.println("Bot is Trying to place on the board on the row: "+moveRow+",col: "+moveColumn);
            if (board.getBoard().get(moveRow).get(moveColumn).getPlayer() != null) {
                System.out.println("Cell is not empty");
                continue;
            }
            else{
                break;
            }
        }
        if(moveRow==-1 || moveColumn==-1){
            System.out.println("An error occured");
            throw new RuntimeException("An error occured during bot play");
        }
        Move move = new Move();
        move.setCol(moveColumn);
        move.setRow(moveRow);
        return move;
    }
}
