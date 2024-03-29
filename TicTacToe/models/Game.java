package TicTacToe.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import TicTacToe.models.*;
import TicTacToe.exceptions.*;
import TicTacToe.strategies.botplayingstrategies.*;
import TicTacToe.strategies.gamewinningstratgeies.*;


public class Game {
    private Board board;
    // why not queue, because of the undo operation
    // Then could have chosen deque, but everytime undo, shifting would happen, so maintian a pointer
    private List<Player> players;
    private GameStatus gameStatus;
    private Player winner;
    private int nextTurnPlayerIndex;
    private List<Move> moves;
    private List<GameWinningStrategies> gameWinningStrategiesEnumList;
    private List<GameWinningStrategy> gameWinningStrategies;
    Scanner scanner;
    private Game(Builder builder) {
        this.players = builder.players;
        this.board = new Board(builder.dimension);
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.nextTurnPlayerIndex = 0;
        this.moves = new ArrayList<>();
        this.gameWinningStrategiesEnumList = builder.gameWinningStrategiesList;
        this.gameWinningStrategies = new ArrayList<>();

        for (GameWinningStrategies gameWinningStrategies1: gameWinningStrategiesEnumList) {
            this.gameWinningStrategies.add(GameWinningStrategyFactory.getStrategyForEnum(gameWinningStrategies1, builder.dimension));
        }
        scanner =new Scanner(System.in);
    }

    public static  Builder getBuilder() {
        return new Builder();
    }

    public void undo() throws NoMoveToUndoException {
        if (moves.size() < 1) {
            throw new NoMoveToUndoException();
        }

        Move lastMove = moves.get(moves.size() - 1);

        this.nextTurnPlayerIndex -= 1; // - 1
        this.nextTurnPlayerIndex += this.players.size(); // 3
        this.nextTurnPlayerIndex %= this.players.size(); // 3

        lastMove.getCell().setPlayer(null);

        moves.remove(moves.size() - 1);

        // 0 0 0 0
        // initially = 0
        // after reduction - 1
        // add players size = 3
        // after mod = 3 % 3 = 3
    }

    public  void  makeMove() throws InvalidMoveException {
        Player currentMovePlayer = this.players.get(nextTurnPlayerIndex);

        Move move = currentMovePlayer.makeMove(board);

        int moveRow = move.getRow();
        int moveColumn = move.getCol();

        if (board.getBoard().get(moveRow).get(moveColumn).getPlayer() != null) {
            throw new InvalidMoveException("Cell is not empty");
        }

        board.getBoard().get(moveRow).get(moveColumn).setPlayer(currentMovePlayer);
        move.setCell(board.getBoard().get(moveRow).get(moveColumn));
        moves.add(move);

        System.out.println("Move happened at row: " + moveRow + " Column: " + moveColumn);

        for (GameWinningStrategy gameWinningStrategy: gameWinningStrategies) {
            if (gameWinningStrategy.checkVictory(board, move)) {
                gameStatus = GameStatus.ENDED;
                winner = currentMovePlayer;
                return;
            }
        }

        if (moves.size() == board.getDimension() * board.getDimension()) {
            gameStatus = GameStatus.DRAW;
            return;
        }

        nextTurnPlayerIndex += 1;
        nextTurnPlayerIndex %= players.size();
    }

    public void printBoard() {
        board.printBoard();
    }

    public void startGame() throws InvalidMoveException, NoMoveToUndoException {
        while (this.getGameStatus().equals(GameStatus.IN_PROGRESS)) {
            Player nextPlayer =  this.getPlayers().get(this.getNextTurnPlayerIndex());
            System.out.println("Next Move is of Player " + nextPlayer.getName());

            if (nextPlayer.getPlayerType().equals(PlayerType.HUMAN)) {
                System.out.println("Do you want to undo? Y/N");
                String undoAnswer = scanner.next();
                if (undoAnswer.equals("Y")) {
                    this.undo();
                    continue;
                }
            }


            this.makeMove();

            this.printBoard();
        }

        if (this.getGameStatus().equals(GameStatus.DRAW)) {
            System.out.println("Game DRAW. No Winner.");
        }

        if (this.getGameStatus().equals(GameStatus.ENDED)) {
            System.out.println("Game has ended. Winner is: " + this.getWinner().getName());
        }
    }

    public static class Builder {
        private int dimension;
        private List<Player> players;
        private List<GameWinningStrategies> gameWinningStrategiesList;

        public Builder setGameWinningStrategiesList(List<GameWinningStrategies> gameWinningStrategiesList) {
            this.gameWinningStrategiesList = gameWinningStrategiesList;
            return this;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        private boolean valid() {
            if (this.players.size() < 2) {
                return false;
            }

            int botCount = 0;

            for (Player player: players) {
                if (player.getPlayerType().equals(PlayerType.BOT)) {
                    botCount += 1;
                }
            }

            if (botCount > 1) {
                return false;
            }

            return true;
        }
        public Game build() throws InvalidGameConstructionParametersException {
            if (!valid()) {
                throw  new InvalidGameConstructionParametersException();
            }

            return new Game(this);
        }
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getNextTurnPlayerIndex() {
        return nextTurnPlayerIndex;
    }

    public void setNextTurnPlayerIndex(int nextTurnPlayerIndex) {
        this.nextTurnPlayerIndex = nextTurnPlayerIndex;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }
}

