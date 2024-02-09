package TicTacToe;

import java.util.List;
import java.util.Scanner;

import TicTacToe.models.*;
import TicTacToe.exceptions.*;
import TicTacToe.strategies.botplayingstrategies.*;
import TicTacToe.strategies.gamewinningstratgeies.*;

public class GameSimulator {
    public static void main(String[] args) throws InvalidGameConstructionParametersException,
            NoMoveToUndoException, InvalidMoveException {



                Game game = Game.getBuilder()
                .setDimension(3)
                .setPlayers(
                        List.of(
                                new HumanPlayer(new Symbol('X'), "Naman"),
                                new HumanPlayer(new Symbol('O'), "Manish")
                        )
                )
                .setGameWinningStrategiesList(
                        List.of(GameWinningStrategies.ORDER_1)
                )
                .build();

//        Game game = Game.getBuilder()
//                .setDimension(3)
//                .setPlayers(
//                        List.of(
//                                new HumanPlayer(new Symbol('X'), "Naman"),
//                                new Bot(new Symbol('O'), "Manish",BotDifficultyLevel.EASY)
//                        )
//                )
//                .setGameWinningStrategiesList(
//                        List.of(GameWinningStrategies.ORDER_1)
//                )
//                .build();


           game.startGame();


    }
}
