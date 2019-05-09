package cisc181.cp_2;

import java.util.Scanner;

/**
 *
 */
public class DiceUI implements UserInput<DiceGame>{
    private DiceGame game;

    GamePiece gamePieceX = new GamePiece('X');
    GamePiece gamePieceO = new GamePiece('O');

    public DiceUI(){
        game = new DiceGame(gamePieceX,gamePieceO,4,4,16);
        game.getGameBoard().getPiece(0,1).setScore(2);
        game.getGameBoard().getPiece(2,1).setScore(3);
        game.getGameBoard().getPiece(2,2).setScore(2);
        game.getGameBoard().getPiece(3,0).setScore(1);
    }

    public DiceGame getGame(){
        return game;
    }

    public DiceAction getUserNextMove(DiceGame game){

        Scanner scr = new Scanner(System.in);

        boolean validMove = false;
        DiceAction move = null;
        int tempScore;
        int row;
        int col;

        while (!validMove){

            // Get the user input for the next move
            System.out.println("Enter T to throw dice");
            String userResponse = scr.next();
            if (userResponse.equals("T") ) {
                tempScore = game.getTurnSymbol().getScore();
                if (tempScore == 0) {
                    row = col = 0;
                } else {

                    row = tempScore / 4;
                    col = tempScore % 4 - 1;
                }
                game.getGameBoard().setPiece(row, col, new GamePiece('E'));
                // Create an instance of the corresponding action
                //  when user tosses their gamepiece, it will randomly land on the board
                tempScore +=  Dice.rollDice();
                if (tempScore >= game.getNumConsecToWin()) {
                    game.getTurnSymbol().setScore(game.getNumConsecToWin());
                    break;
                }
                System.out.println(tempScore);

                row = tempScore / 4;

                col = (tempScore- 1) % 4 ;
                GamePiece gamePiece = game.getGameBoard().getPiece(row, col);
                while (gamePiece.isEmpty() && gamePiece.getScore() != 0) {

                    tempScore += gamePiece.getScore();
                    if (!game.isEnd()) {
                        row = tempScore / 4;

                        col = tempScore % 4 - 1;
                        gamePiece = game.getGameBoard().getPiece(row, col);
                    } else {
                        break;
                    }
                }




                move = new DiceAction(game.getTurnSymbol(), row, col);
                validMove = move.isValid(game);
            }
            // check if its a valid move
            if(!validMove){
                System.out.println("Invalid Move - try again");
            }
        }
        return move;
    }

    public static void main(String args[]){

        DiceUI ttt = new DiceUI();
        boolean gameEnded = false;
        DiceAction nextMove;

        while (!ttt.getGame().isEnd()){
            // print status of game
            System.out.println(ttt.getGame());
            // get the next move from the user
            nextMove = ttt.getUserNextMove(ttt.getGame());
            // print the next move
            System.out.println(nextMove);
            // perform the next move
            ttt.getGame().performAction(nextMove);
        }
        System.out.println(ttt.getGame());
    }
}
