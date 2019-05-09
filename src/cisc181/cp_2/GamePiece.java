package cisc181.cp_2;

public class GamePiece  {

    public static final char EMPTY = 'E';
    private char symbol;

    //piece's score or position bonus
    private int score = 0;

    public GamePiece(char symbol) {
        this.symbol = symbol;
    }

    /**
     * getter method
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * setter method
     * @param score score
     */
    public void setScore(int score) {
        this.score = score;
    }

    public char getSymbol() {
        return symbol;
    }

    public boolean isEmpty() {
        return symbol == EMPTY;
    }

    public String toString() {
        if (score != 0 && symbol == 'E') {

            return Integer.toString(score);
        }
        return Character.toString(symbol);
    }

    @Override
    public boolean equals(Object other) {

        // If the object is compared with itself then return true
        if (other == this) {
            return true;
        }
        // Check if other is an instance of GamePiece or not
        if (!(other instanceof GamePiece)) {
            return false;
        }
        // typecast other to GamePiece so that we can compare data members
        GamePiece otherPiece = (GamePiece)other;

        // Compare the data members and return accordingly
        return this.symbol == otherPiece.getSymbol();
    }
}
