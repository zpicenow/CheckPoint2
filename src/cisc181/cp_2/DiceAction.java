package cisc181.cp_2;

/**
 * my action to implement action
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
     *
     */
    @Override

    public String toString() {
        return "Player: "+ player +" move to "+ row +"," +column;
    }

    @Override
    public boolean isValid(DiceGame game) {
        if (game.getGameBoard().isInBounds(row, column) && game.getTurnSymbol() == player) {
            if (!game.getGameBoard().getPiece(row, column).isEmpty()) {
                game.getGameBoard().setPiece(row, column, new GamePiece('#'));
            }
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void update(DiceGame game) {

        game.setPiece(row, column, player);
        row = game.getNotTurnSymbol().getScore();
        if (row != 0) {
            row = (row - 1) / 4;
            column = (game.getNotTurnSymbol().getScore() - 1) % 4;
            game.setPiece(row, column, game.getNotTurnSymbol());
        }


        game.changeTurn();
    }
}
