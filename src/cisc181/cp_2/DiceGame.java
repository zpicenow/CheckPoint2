package cisc181.cp_2;

/**
 * my game class extended Game
 */
public class DiceGame extends Game{

    private GameBoard gameBoard;
    // represents whose turn it is
    private GamePiece turnSymbol;
    // represents whose turn it is not
    private GamePiece notTurnSymbol;
    private int numConsecToWin;

    /**
     * constructor
     * @param turnSymbol player now place piece
     * @param notTurnSymbol another player
     * @param numRows row number
     * @param numCols column number
     * @param numConsecToWin how to win
     */
    public DiceGame(GamePiece turnSymbol, GamePiece notTurnSymbol, int numRows, int numCols, int numConsecToWin){
        this.gameBoard = new GameBoard(setUpEmptyArray(numRows,numCols));
        this.turnSymbol = turnSymbol;
        this.notTurnSymbol = notTurnSymbol;
        this.numConsecToWin = numConsecToWin;
    }

    /**
     * getter method
     * @return gameboard
     */

    public GameBoard getGameBoard(){
        return  gameBoard;
    }

    /**
     * getter method
     * @return player now char
     */
    public GamePiece getTurnSymbol(){
        return  turnSymbol;
    }

    /**
     * getter method
     * @return another player
     */
    public GamePiece getNotTurnSymbol(){
        return  notTurnSymbol;
    }

    /**
     * change player turn
     */
    public void changeTurn() {
        GamePiece current = turnSymbol;
        turnSymbol = notTurnSymbol;
        notTurnSymbol = current;
    }

    /**
     * set cheese position
     * @param row row
     * @param column column
     * @param piece cheese
     */
    public void setPiece(int row, int column, GamePiece piece) {

        gameBoard.setPiece(row,column,piece);
    }

    /**
     * whether game over or not
     * @return boolean
     */
    public boolean isEnd() {
        return isWinner(turnSymbol) || isWinner(notTurnSymbol);
    }

    // Player wins if num consec in a row
    public boolean isWinner(GamePiece gamePiece) {
        return gamePiece.getScore() >= numConsecToWin;

    }

    public int getNumConsecToWin() {
        return numConsecToWin;
    }

    public String getStatus() {
        if (isEnd()) {
            if (isWinner(turnSymbol)) {
                return "\nPlayer " + getTurnSymbol() + " wins!\n";
            }
            else if (isWinner(getNotTurnSymbol())) {
                return "\nPlayer " + getNotTurnSymbol() + " wins!\n";
            }
            else {
                return "\nIt is a draw.\n";
            }
        }
        else {
            return "\nPlayer " + turnSymbol + "'s turn\n";
        }
    }

    public static GamePiece [][] setUpEmptyArray(int numRows, int numCols){

        // create a 2D array that will hold all the game pieces
        GamePiece [][]  arrayOfEmpty = new GamePiece[numRows][numCols];
        // Fill the array with empty pieces
        for (int row = 0; row < numRows; row++){
            for (int col = 0; col < numCols; col++){
                arrayOfEmpty[row][col] = new GamePiece(GamePiece.EMPTY);
            }
        }
        return arrayOfEmpty;
    }

    @Override
    public String toString() {
        String status =   gameBoard.toString();
        status += "\n" + getStatus();
        return status;
    }
}



