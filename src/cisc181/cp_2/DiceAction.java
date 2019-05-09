package cisc181.cp_2;

/**
 *
 */
public class DiceAction implements Action<DiceGame>{
    private GamePiece player;
    private int row;
    private int column;

    public DiceAction(GamePiece player, int row, int column) {
        this.player = player;
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public GamePiece getPlayer(){return player;}

    /**
     * Placing a piece is only valid if:
     * 1. It is within the bounds of the board
     * 2. and it is the player's turn
     * 3. and it is the "empty" piece at the given row/column
     */
    @Override

    public String toString() {
        return "Player: "+ player +" move to "+ row +"," +column;
    }

    @Override
    public boolean isValid(DiceGame game) {
        return game.getGameBoard().isInBounds(row, column) &&
                game.getTurnSymbol() == player &&
                game.getGameBoard().getPiece(row,column).isEmpty();
    }

    @Override
    public void update(DiceGame game) {
        game.setPiece(row, column, player);
        game.changeTurn();
    }
}
